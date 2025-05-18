package com.example.pdf_reader_ms.model.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PdfAnalyzerAttachmentDto {
    private String fileName;
    private String fileId;
    private String sourceDomain;
    private String sourceBankName;
    private String fileDataBase64;
    private LocalDateTime createdAt;
}
