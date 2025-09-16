package com.learnSpring.DataJPA.hospitalManagement;


import com.learnSpring.DataJPA.hospitalManagement.entity.Patient;
import com.learnSpring.DataJPA.hospitalManagement.repository.PatientRepository;
import com.learnSpring.DataJPA.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

        Patient p = new Patient();
        patientRepository.save(p);
    }

    @Test
    public void testTransactionMethod() {
        Patient patient = patientService.getPatientById(1L);

        System.out.println(patient);

    }

}
