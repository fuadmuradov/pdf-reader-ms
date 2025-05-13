package com.example.pdf_reader_ms.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "pdf_reader_personal_infos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PdfReaderPersonalInfo {
    @Id
    private Long id;
    private String pin;
    private String name;
    private String surname;
    private String nameEn;
    private String surnameEn;
    private String patronymic;
    @OneToOne(cascade = {PERSIST, MERGE, REMOVE}, fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private PdfReaderRequest request;
}
