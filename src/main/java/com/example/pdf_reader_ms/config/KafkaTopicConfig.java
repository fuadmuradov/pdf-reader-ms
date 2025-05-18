package com.example.pdf_reader_ms.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic pdfReaderRequestTopic() {
        return TopicBuilder.name("pdf-reader-request-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic pdfReaderResponseTopic() {
        return TopicBuilder.name("pdf-reader_response-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
