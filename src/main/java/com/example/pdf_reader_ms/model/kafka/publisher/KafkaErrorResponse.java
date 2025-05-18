package com.example.pdf_reader_ms.model.kafka.publisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaErrorResponse {
    private int statusCode;
    private String code;
    private String message;
}
