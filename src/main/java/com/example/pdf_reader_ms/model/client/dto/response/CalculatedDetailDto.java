package com.example.pdf_reader_ms.model.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalculatedDetailDto {
    private String sourceBankName;
    private Boolean isDateModified;
    private TurnoverDetailDto nonAbbTurnoverDetails;
}
