package com.example.pdf_reader_ms.service.concrete;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, Object message) {
        kafkaTemplate.send(topic, message);
    }
}
