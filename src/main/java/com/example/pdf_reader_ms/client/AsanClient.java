package com.example.pdf_reader_ms.client;

import com.example.pdf_reader_ms.model.client.dto.response.PersonalInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asan-personal", url = "${client.asan.url}", path = "${client.asan.path}")
public interface AsanClient {

    @GetMapping("{pin}")
    public PersonalInfoDto getPersonalInfo(@PathVariable String pin);
}
