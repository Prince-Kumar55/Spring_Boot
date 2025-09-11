package com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service.impl;

import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.entity.Student;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.repository.StundentRepository;
import com.codingshuttle.learnSpringBoot.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StundentRepository stundentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = stundentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = stundentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student is not found with ID: " +id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = stundentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }
}
