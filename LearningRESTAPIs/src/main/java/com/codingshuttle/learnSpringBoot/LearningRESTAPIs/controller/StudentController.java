package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.controller;


import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;



    @GetMapping("/Students")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }


    @GetMapping("/Students/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
