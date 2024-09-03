package com.example.crud_spring_boot.service;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.entity.Student;
import com.example.crud_spring_boot.interfaces.ResponseStudentMapper;
import com.example.crud_spring_boot.interfaces.StudentService;
import com.example.crud_spring_boot.repository.StudentRepository;
import com.example.crud_spring_boot.utils.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<Student> students = studentRepository.findAll();

        return responseStudentMapper.toResponseStudentDTOs(students);
    }

    @Override
    public ResponseStudentDTO getStudentById(long id) {
        return null;
    }

    @Override
    public ResponseStudentDTO update(long studentId, StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new StudentNotFoundException("Student not found"));

        // Atualiza apenas se for enviado os valores
        if (studentDTO.getFullName() != null) {
            student.setFullName(studentDTO.getFullName());
        }
        if (studentDTO.getAge() != null) {
            student.setAge(studentDTO.getAge());
        }

        boolean isGrade1Updated = studentDTO.getGrade1() != null;
        boolean isGrade2Updated = studentDTO.getGrade2() != null;

        if (isGrade1Updated) {
            student.setGrade1(studentDTO.getGrade1());
        }
        if (isGrade2Updated) {
            student.setGrade2(studentDTO.getGrade2());
        }

        if (isGrade1Updated || isGrade2Updated) {
             student.setAverage(calculateAverage(student.getGrade1(),
                    student.getGrade2()));
        }

        Student studentSaved = studentRepository.save(student);

        return responseStudentMapper.toResponseStudentDTO(studentSaved);
    }

    @Override
    public ResponseStudentDTO delete(long id) {
        return null;
    }

    public double calculateAverage(double grade1, double grade2) {
        return (grade1 + grade2) / 2;
    }
}
