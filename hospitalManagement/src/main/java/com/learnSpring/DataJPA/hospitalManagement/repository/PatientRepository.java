package com.learnSpring.DataJPA.hospitalManagement.repository;


import com.learnSpring.DataJPA.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
