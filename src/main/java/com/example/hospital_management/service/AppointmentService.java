package com.example.hospital_management.service;

import com.example.hospital_management.model.Appointment;
import com.example.hospital_management.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Schedule appointment
    public Appointment scheduleAppointment(Appointment appointment) {
        appointment.setStatus("SCHEDULED");
        return appointmentRepository.save(appointment);
    }

    // Update appointment
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        appointment.setDoctor(updatedAppointment.getDoctor());

        return appointmentRepository.save(appointment);
    }

    // Cancel appointment
    public void cancelAppointment(Long id) {
        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);
    }
}
