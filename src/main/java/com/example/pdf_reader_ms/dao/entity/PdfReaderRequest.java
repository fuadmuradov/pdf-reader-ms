package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "pdf_reader_requests")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PdfReaderRequest {
    @Id
    private Long id;
    private LocalDateTime requestDate;
    private Long loanOrderId;
    private String voen;
    @OneToOne(mappedBy = "request", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private PdfReaderPersonalInfo personalInfo;
    @OneToMany(mappedBy = "request", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private List<PdfReaderAttachment> attachments;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
