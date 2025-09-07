package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.controller;


import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.entity.Student;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.repository.StundentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class StudentController {

    private final StundentRepository stundentRepository;

    public StudentController(StundentRepository stundentRepository) {
        this.stundentRepository = stundentRepository;
    }

    @GetMapping("/Student")
    public List<Student> getStudent(){
        return stundentRepository.findAll();
    }


    @GetMapping("/Student/{id}")
    public StudentDto getStudentById() {
        return new StudentDto(4L, "Prince", "Prince@gmail.com");
    }
}
