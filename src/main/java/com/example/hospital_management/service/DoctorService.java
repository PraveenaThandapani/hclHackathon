package com.example.hospital_management.service;

import com.example.hospital_management.model.Doctor;
import com.example.hospital_management.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return repository.findById(id);
    }

    public Doctor updateDoctor(Long id, Doctor newDoctor) {
        return repository.findById(id).map(doctor -> {
            doctor.setName(newDoctor.getName());
            doctor.setEmail(newDoctor.getEmail());
            doctor.setPhone(newDoctor.getPhone());
            doctor.setSpecialization(newDoctor.getSpecialization());
            doctor.setExperience(newDoctor.getExperience());
            doctor.setAvailable(newDoctor.isAvailable());
            return repository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }
}