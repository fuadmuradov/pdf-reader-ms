package com.example.pdf_reader_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableFeignClients
public class PdfReaderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfReaderMsApplication.class, args);
	}

}
