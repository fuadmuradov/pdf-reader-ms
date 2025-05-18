package com.example.pdf_reader_ms.model.kafka.publisher;

import com.example.pdf_reader_ms.model.client.dto.response.PdfAnalyzerResponseDto;
import com.example.pdf_reader_ms.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
    private Status status;
    private PdfAnalyzerResponseDto result;
    private List<KafkaErrorResponse> errors;
}
