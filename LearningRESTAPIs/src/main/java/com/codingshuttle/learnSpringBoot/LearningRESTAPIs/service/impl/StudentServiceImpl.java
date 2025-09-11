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
import java.util.Map;


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

    @Override
    public void deleteStudentById(Long id) {
        if (!stundentRepository.existsById(id)){
            throw new IllegalArgumentException("Student Does not exists by id: "+id);
        }
        stundentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = stundentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student is not found with ID: " +id));
        modelMapper.map(addStudentRequestDto, student);

            student = stundentRepository.save(student);
            return modelMapper.map(student,StudentDto.class);


    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = stundentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student is not found with ID: " +id));

        updates.forEach((field, value) -> {
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported ");
            }
        });
        Student savedstudent = stundentRepository.save(student);
        return modelMapper.map(savedstudent,StudentDto.class);

    }
}
