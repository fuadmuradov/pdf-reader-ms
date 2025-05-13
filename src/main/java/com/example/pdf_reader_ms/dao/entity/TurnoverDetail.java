package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pdf_reader_turnover_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TurnoverDetail {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private BigDecimal totalIncomingTransaction12M;
    private BigDecimal loanDisbursement12M;
    private BigDecimal currencyExchange12M;
    private BigDecimal selfTransfers12M;
    private BigDecimal nonAbbTurnoverL12M;
    private BigDecimal minBalanceAznL3M;
    private BigDecimal maxBalanceAznL1M;
    private BigDecimal maxMoneyReceiveL3M;
    private BigDecimal cntAtmWithdrawalL3M;
    @OneToOne
    @JoinColumn(name = "response_id")
    private PdfReaderResponse response;
    @OneToOne
    @JoinColumn(name = "calculated_detail_id")
    private CalculatedDetail calculatedDetail;
}
