package com.example.pdf_reader_ms.client;

import com.example.pdf_reader_ms.model.client.dto.response.PdfFileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="file-net-service", url = "${client.filenet.url}", path = "${client.filenet.path}")
public interface FileNetClient {

    @GetMapping("{fileId}")
    public PdfFileDto getFile(@PathVariable String fileId);

}
