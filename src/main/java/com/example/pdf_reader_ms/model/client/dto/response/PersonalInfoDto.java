package com.example.pdf_reader_ms.model.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalInfoDto {
    private String pin;
    private String name;
    private String surname;
    private String nameEn;
    private String surnameEn;
    private String patronymic;
}
