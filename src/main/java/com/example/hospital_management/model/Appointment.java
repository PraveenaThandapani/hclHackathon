package com.example.hospital_management.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;
    private String status; // SCHEDULED, CANCELLED

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    public void setStatus(String scheduled) {
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

    public String getStatus() {
        return status;
    }

    public Appointment() {
    }

    public Appointment(LocalDate appointmentDate, Doctor doctor, Long id, Patient patient, String status) {
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.id = id;
        this.patient = patient;
        this.status = status;
    }


}
