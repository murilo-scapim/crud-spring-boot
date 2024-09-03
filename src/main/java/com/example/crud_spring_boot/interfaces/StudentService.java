package com.example.crud_spring_boot.interfaces;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import org.springframework.hateoas.EntityModel;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface StudentService {

    ResponseStudentDTO create(StudentDTO studentDTO);

    List<ResponseStudentDTO> getStudents();

    EntityModel<ResponseStudentDTO> getStudentById(long studentId);

    ResponseStudentDTO update(long studentId, StudentDTO studentDTO);

    void delete(long studentId);
}
