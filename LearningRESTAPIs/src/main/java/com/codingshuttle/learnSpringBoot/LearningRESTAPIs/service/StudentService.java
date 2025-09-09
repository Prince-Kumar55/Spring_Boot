package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service;

import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudent();
}
