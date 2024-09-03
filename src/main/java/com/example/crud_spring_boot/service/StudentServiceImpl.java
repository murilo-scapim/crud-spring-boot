package com.example.crud_spring_boot.service;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.entity.Student;
import com.example.crud_spring_boot.interfaces.ResponseStudentMapper;
import com.example.crud_spring_boot.interfaces.StudentMapper;
import com.example.crud_spring_boot.interfaces.StudentService;
import com.example.crud_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ResponseStudentMapper responseStudentMapper;

    @Override
    public ResponseStudentDTO create(StudentDTO studentDTO) {
        double average = calculateAverage(studentDTO.getGrade1(),
                studentDTO.getGrade2());

        Student student = Student.builder()
                .fullName(studentDTO.getFullName())
                .age(studentDTO.getAge())
                .grade1(studentDTO.getGrade1())
                .grade2(studentDTO.getGrade2())
                .average(average)
                .build();

        Student studentSaved = studentRepository.save(student);

        return responseStudentMapper.toResponseStudentDTO(studentSaved);
    }

    @Override
    public List<ResponseStudentDTO> getStudents() {
        return null;
    }

    @Override
    public StudentDTO getStudentById(long id) {
        return null;
    }

    @Override
    public StudentDTO update(long id, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO delete(long id) {
        return null;
    }

    public double calculateAverage(double grade1, double grade2) {
        return (grade1 + grade2) / 2;
    }
}
