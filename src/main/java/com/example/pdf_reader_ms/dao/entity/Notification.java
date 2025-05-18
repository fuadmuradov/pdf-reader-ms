package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pdf_reader_notifications")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String type;
    private String description;
    @ManyToOne
    @JoinColumn(name = "response_id")
    private PdfReaderResponse response;

}
