package com.example.pdf_reader_ms.dao.repo;

import com.example.pdf_reader_ms.dao.entity.PdfReaderAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PdfReaderAttachmentRepository extends JpaRepository<PdfReaderAttachment, Long> {
    Optional<PdfReaderAttachment> findById(Long id);
    Optional<PdfReaderAttachment> findByIdAndRequestId(Long id, Long requestId);
}
