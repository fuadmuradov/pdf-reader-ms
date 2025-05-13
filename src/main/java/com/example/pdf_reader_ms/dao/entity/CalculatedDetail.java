package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pdf_reader_calculated_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CalculatedDetail {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String sourceBankName;
    private Boolean isDateModified;
    @ManyToOne
    @JoinColumn(name = "response_id")
    private PdfReaderResponse response;
    @OneToOne(mappedBy = "calculatedDetail", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private TurnoverDetail turnoverDetail;
}
