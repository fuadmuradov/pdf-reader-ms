package com.example.pdf_reader_ms.dao.repo;

import com.example.pdf_reader_ms.dao.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}
