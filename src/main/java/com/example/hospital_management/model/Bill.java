package com.example.hospital_management.model;

import jakarta.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String paymentStatus; // PAID / PENDING

    @ManyToOne
    private Patient patient;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Bill() {
    }

    public Bill(double amount, Long id, Patient patient, String paymentStatus) {
        this.amount = amount;
        this.id = id;
        this.patient = patient;
        this.paymentStatus = paymentStatus;
    }
}
