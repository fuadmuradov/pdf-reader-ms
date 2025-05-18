package com.example.pdf_reader_ms.service.concrete;

import com.example.pdf_reader_ms.client.AsanClient;
import com.example.pdf_reader_ms.client.FileNetClient;
import com.example.pdf_reader_ms.client.PdfAnalyzerClient;
import com.example.pdf_reader_ms.dao.entity.OrderStatus;
import com.example.pdf_reader_ms.dao.entity.PdfReaderAttachment;
import com.example.pdf_reader_ms.dao.repo.OrderStatusRepository;
import com.example.pdf_reader_ms.dao.repo.PdfReaderRequestRepository;
import com.example.pdf_reader_ms.exception.CustomFeignException;
import com.example.pdf_reader_ms.exception.NotFoundException;
import com.example.pdf_reader_ms.model.client.dto.request.PdfAnalyzerAttachmentDto;
import com.example.pdf_reader_ms.model.client.dto.response.PersonalInfoDto;
import com.example.pdf_reader_ms.model.enums.Status;
import com.example.pdf_reader_ms.model.kafka.consumer.AttachmentDto;
import com.example.pdf_reader_ms.model.kafka.consumer.RequestDto;
import com.example.pdf_reader_ms.model.kafka.publisher.ClientResponse;
import com.example.pdf_reader_ms.model.kafka.publisher.KafkaErrorResponse;
import com.example.pdf_reader_ms.service.abstracts.PdfOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.pdf_reader_ms.mapper.AttachmentMapper.ATTACHMENT_MAPPER;
import static com.example.pdf_reader_ms.mapper.RequestMapper.REQUEST_MAPPER;
import static com.example.pdf_reader_ms.model.constants.ErrorConstants.PDF_FILE_NOT_FOUND;
import static com.example.pdf_reader_ms.model.constants.ErrorConstants.PERSONAL_INFO_NOT_FOUND;
import static com.example.pdf_reader_ms.model.enums.Status.CANCELED;

@RequiredArgsConstructor
@Service
public class PdfOperationImpl implements PdfOperation {
    @Value("pdf-reader_response-topic")
    private String responseTopic;
    private final FileNetClient fileNetClient;
    private final OrderStatusRepository orderStatusRepository;
    private final PdfReaderRequestRepository requestRepository;
    private final AsanClient asanClient;
    private final PdfAnalyzerClient pdfAnalyzerClient;
    private final KafkaProducerService kafkaProducer;

    @Override
    public void operate(RequestDto request) {
        var validationErrors = validate(request);
        if (validationErrors != null) {
            saveCanceledOrderStatus(request);
            kafkaProducer.send(responseTopic, ClientResponse.builder()
                    .errors(validationErrors)
                    .status(CANCELED)
                    .build());
        } else {
            handleMainOperations(request);
        }
    }

    private void saveCanceledOrderStatus(RequestDto request) {
        orderStatusRepository.save(OrderStatus.builder()
                .status(CANCELED)
                .requestId(request.getRequestId().toString())
                .build());
    }

    private void handleMainOperations(RequestDto request) {
        var orderStatus = orderStatusRepository.save(OrderStatus.builder()
                .status(Status.PENDING)
                .requestId(request.getRequestId().toString())
                .build());

        var requestEntity = REQUEST_MAPPER.mapToEntity(request);
        requestEntity.setId(orderStatus.getId());

        try {
            var attachmentEntities = mapAndMarkExistingAttachments(request);
            requestEntity.setAttachments(attachmentEntities);
            requestRepository.save(requestEntity);

            var personalInfo = getPersonalInfo(request.getFin());
            // Further logic can be added here if needed
        } catch (NotFoundException ex) {
            kafkaProducer.send(responseTopic, ClientResponse.builder()
                    .errors(List.of(KafkaErrorResponse.builder().build()))
                    .status(CANCELED)
                    .build());
        }
    }

    private List<PdfReaderAttachment> mapAndMarkExistingAttachments(RequestDto request) {
        var attachments = request.getAttachments();
        var attachmentEntities = attachments.stream()
                .map(ATTACHMENT_MAPPER::mapToEntity)
                .toList();

        var existingFiles = getPdfFilesFromFileNet(attachments);

        if (existingFiles.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND.value(),
                    PDF_FILE_NOT_FOUND.getCode(),
                    PDF_FILE_NOT_FOUND.getMessage());
        }

        attachmentEntities.forEach(attachment -> {
            boolean exists = existingFiles.stream()
                    .anyMatch(file -> Objects.equals(file.getFileId(), attachment.getFileId()));
            if (exists) {
                attachment.setPdfExist(true);
            }
        });

        return attachmentEntities;
    }

    private List<PdfAnalyzerAttachmentDto> getPdfFilesFromFileNet(List<AttachmentDto> files) {
        List<PdfAnalyzerAttachmentDto> pdfFiles = new ArrayList<>();
        for (AttachmentDto file : files) {
            try {
                var fileDto = fileNetClient.getFile(file.getFileId());
                var pdfAnalyzerAttachment = PdfAnalyzerAttachmentDto.builder()
                        .fileId(file.getFileId())
                        .fileName(file.getFileName())
                        .sourceBankName(file.getSourceBankName())
                        .sourceDomain(file.getSourceDomain())
                        .createdAt(file.getPdfCreationDate())
                        .fileDataBase64(fileDto.getFileBase64())
                        .build();
                pdfFiles.add(pdfAnalyzerAttachment);
            } catch (CustomFeignException ignored) {
                // Optional: log or collect partial results
            }
        }
        return pdfFiles;
    }

    private PersonalInfoDto getPersonalInfo(String pin) {
        try {
            return asanClient.getPersonalInfo(pin);
        } catch (CustomFeignException ex) {
            throw new NotFoundException(HttpStatus.NOT_FOUND.value(),
                    PERSONAL_INFO_NOT_FOUND.getCode(),
                    PERSONAL_INFO_NOT_FOUND.getMessage());
        }
    }

    @Override
    public List<KafkaErrorResponse> validate(RequestDto request) {
        // TODO: Implement validation logic
        return null;
    }
}
