package com.example.pdf_reader_ms.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "unexpected exception"),
    PDF_FILE_NOT_FOUND("PDF_FILE_NOT_FOUND", "pdf file not found"),
    PERSONAL_INFO_NOT_FOUND("PERSONAL_INFO_NOT_FOUND", "personal info not found");



    private final String code;
    private final String message;
}
