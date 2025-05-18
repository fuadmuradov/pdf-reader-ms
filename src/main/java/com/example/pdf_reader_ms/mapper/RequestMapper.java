package com.example.pdf_reader_ms.mapper;

import com.example.pdf_reader_ms.dao.entity.PdfReaderRequest;
import com.example.pdf_reader_ms.model.kafka.consumer.RequestDto;

public enum RequestMapper {
    REQUEST_MAPPER;
    public PdfReaderRequest mapToEntity(RequestDto requestDto){
        return PdfReaderRequest.builder()
                .loanOrderId(Long.parseLong(requestDto.getLoanOrderId()))
                .requestDate(requestDto.getRequestDate())
                .pin(requestDto.getFin())
                .voen(requestDto.getVoen())
                .build();
    }
}
