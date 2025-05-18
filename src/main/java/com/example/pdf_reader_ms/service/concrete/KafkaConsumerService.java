package com.example.pdf_reader_ms.service.concrete;

import com.example.pdf_reader_ms.model.kafka.consumer.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    @KafkaListener(topics = "pdf-reader-request-topic", groupId = "reader-group-id")
    public void listen(RequestDto message) {
        System.out.println("Listening message: " + message.toString());
    }

}
