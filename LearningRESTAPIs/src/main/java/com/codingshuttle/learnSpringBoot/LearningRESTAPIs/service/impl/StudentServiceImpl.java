package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service.impl;

import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.entity.Student;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.repository.StundentRepository;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StundentRepository stundentRepository;


    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = stundentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
        return List.of();
    }
}
