package com.example.pdf_reader_ms.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final int statusCode;
    private final String code;
    public NotFoundException(int statusCode, String code, String message) {
        super(message);
        this.statusCode = statusCode;
        this.code = code;
    }
}
