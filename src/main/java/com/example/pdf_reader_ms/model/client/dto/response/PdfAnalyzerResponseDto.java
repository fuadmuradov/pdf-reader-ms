package com.example.pdf_reader_ms.model.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PdfAnalyzerResponseDto {
    private String requestId;
    private String responseDate;
    private Long loanOrderId;
    private String voen;
    private String pin;
    private String status;
    private List<NotificationDto> notifications;
    private TurnoverDetailDto nonAbbTurnoverDetails;
    private CalculatedDetailDto calculatedFieldsDetails;
}
