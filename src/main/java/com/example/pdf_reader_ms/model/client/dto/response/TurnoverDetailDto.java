package com.example.pdf_reader_ms.model.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TurnoverDetailDto {
    private BigDecimal totalIncomingTransaction12M;
    private BigDecimal loanDisbursement12M;
    private BigDecimal currencyExchange12M;
    private BigDecimal selfTransfers12M;
    private BigDecimal nonAbbTurnoverL12M;
    private BigDecimal minBalanceAznL3M;
    private BigDecimal maxBalanceAznL1M;
    private BigDecimal maxMoneyReceiveL3M;
    private BigDecimal cntAtmWithdrawalL3M;
}
