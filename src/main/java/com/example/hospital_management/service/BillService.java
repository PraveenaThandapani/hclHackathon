package com.example.hospital_management.service;

import com.example.hospital_management.model.Bill;
import com.example.hospital_management.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    // Generate bill
    public Bill generateBill(Bill bill) {
        bill.setPaymentStatus("PENDING");
        return billRepository.save(bill);
    }

    // Update payment status
    public Bill updatePaymentStatus(Long id, String status) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        bill.setPaymentStatus(status);
        return billRepository.save(bill);
    }
}
