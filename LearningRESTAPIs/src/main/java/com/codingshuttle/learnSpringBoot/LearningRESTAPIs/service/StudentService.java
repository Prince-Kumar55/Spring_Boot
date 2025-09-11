package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service;

import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);
}
