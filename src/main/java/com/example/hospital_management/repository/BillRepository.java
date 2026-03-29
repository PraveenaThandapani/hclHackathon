package com.example.hospital_management.repository;

import com.example.hospital_management.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
