package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pdf_reader_attachments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PdfReaderAttachment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String sourceBankName;
    private String sourceDomain;
    private LocalDateTime pdfCreationDate;
    private String fileName;
    private Boolean pdfExist;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private PdfReaderRequest request;
}

