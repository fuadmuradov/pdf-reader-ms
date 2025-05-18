package com.example.pdf_reader_ms.client;

import com.example.pdf_reader_ms.model.client.dto.request.PdfAnalyzerRequestDto;
import com.example.pdf_reader_ms.model.client.dto.response.PdfAnalyzerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pdf-analyzer-ms", url = "${client.pdf-analyzer.url}", path = "${client.pdf-analyzer.path}")
public interface PdfAnalyzerClient {
    @PostMapping
    public PdfAnalyzerResponseDto calculatePdf(@RequestBody PdfAnalyzerRequestDto pdfAnalyzerRequestDto);
}
