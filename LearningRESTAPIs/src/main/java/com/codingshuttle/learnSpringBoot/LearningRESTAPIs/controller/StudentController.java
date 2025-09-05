package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.controller;


import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/Student")
    public StudentDto getStudent() {
        return new StudentDto(4L, "Prince", "Prince@gmail.com");
    }


    @GetMapping("/Student/{id}")
    public StudentDto getStudentById() {
        return new StudentDto(4L, "Prince", "Prince@gmail.com");
    }
}
