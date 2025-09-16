package com.learnSpring.DataJPA.hospitalManagement.service;


import com.learnSpring.DataJPA.hospitalManagement.entity.Patient;
import com.learnSpring.DataJPA.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
private final PatientRepository patientRepository;

@Transactional
public Patient getPatientById(Long id){

    Patient p1 = patientRepository.findById(id).orElseThrow();

    Patient p2 = patientRepository.findById(id).orElseThrow();

    p1.setName("YoYo");

    return p1;

}

}
