package com.example.pdf_reader_ms.dao.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "pdf_reader_responses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PdfReaderResponse {
    @Id
    private long id;
    private String status;
    @OneToMany(mappedBy = "response", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private List<Notification> notifications;
    @OneToMany(mappedBy = "response", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private List<CalculatedDetail> calculatedDetails;
    @OneToOne(mappedBy = "response", cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    private TurnoverDetail turnoverDetail;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
