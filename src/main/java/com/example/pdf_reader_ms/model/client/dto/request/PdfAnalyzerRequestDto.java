package com.example.pdf_reader_ms.model.client.dto.request;

import com.example.pdf_reader_ms.model.client.dto.response.PersonalInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PdfAnalyzerRequestDto {
    private String requestId;
    private LocalDateTime requestDate;
    private Long loanOrderId;
    private String voen;
    private PersonalInfoDto personalInfo;
    private List<PdfAnalyzerAttachmentDto> attachments;
}
