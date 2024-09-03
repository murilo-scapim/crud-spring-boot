package com.example.crud_spring_boot.interfaces;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.entity.Student;

import java.util.List;

public interface StudentService {

    ResponseStudentDTO create(StudentDTO studentDTO);

    List<ResponseStudentDTO> getStudents();

    StudentDTO getStudentById(long id);

    StudentDTO update(long id, StudentDTO studentDTO);

    StudentDTO delete(long id);
}
