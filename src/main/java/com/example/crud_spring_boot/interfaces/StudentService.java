package com.example.crud_spring_boot.interfaces;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import org.springframework.hateoas.EntityModel;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface StudentService {

    EntityModel<ResponseStudentDTO> create(StudentDTO studentDTO);

    List<EntityModel<ResponseStudentDTO>> getStudents();

    EntityModel<ResponseStudentDTO> getStudentById(long studentId);

    EntityModel<ResponseStudentDTO> update(long studentId, StudentDTO studentDTO);

    void delete(long studentId);
}
