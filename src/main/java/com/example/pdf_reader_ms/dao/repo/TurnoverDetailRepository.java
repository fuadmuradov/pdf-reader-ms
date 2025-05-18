package com.example.pdf_reader_ms.dao.repo;

import com.example.pdf_reader_ms.dao.entity.TurnoverDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoverDetailRepository extends JpaRepository<TurnoverDetail, Long> {
}
