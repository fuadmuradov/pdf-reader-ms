package com.example.pdf_reader_ms.mapper;

import com.example.pdf_reader_ms.dao.entity.PdfReaderAttachment;
import com.example.pdf_reader_ms.model.kafka.consumer.AttachmentDto;

public enum AttachmentMapper {
    ATTACHMENT_MAPPER;

    public PdfReaderAttachment mapToEntity(AttachmentDto attachmentDto) {
        return PdfReaderAttachment.builder()
                .fileId(attachmentDto.getFileId())
                .fileName(attachmentDto.getFileName())
                .sourceDomain(attachmentDto.getSourceDomain())
                .sourceBankName(attachmentDto.getSourceBankName())
                .pdfCreationDate(attachmentDto.getPdfCreationDate())
                .pdfExist(false)
                .build();
    }

}
