package com.example.pdf_reader_ms.service.abstracts;

import com.example.pdf_reader_ms.model.kafka.consumer.RequestDto;
import com.example.pdf_reader_ms.model.kafka.publisher.KafkaErrorResponse;

import java.util.List;

public interface PdfOperation {
    void operate(RequestDto request);
    List<KafkaErrorResponse> validate(RequestDto request);

}
