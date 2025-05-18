package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.*;
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
@Getter
@Setter
public class PdfReaderRequest {
    @Id
    private Long id;
    private LocalDateTime requestDate;
    private Long loanOrderId;
    private String voen;
    private String pin;
    @OneToMany(mappedBy = "request", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private List<PdfReaderAttachment> attachments;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
