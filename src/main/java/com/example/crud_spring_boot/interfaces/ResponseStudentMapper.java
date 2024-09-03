package com.example.crud_spring_boot.interfaces;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseStudentMapper {
    ResponseStudentDTO toResponseStudentDTO(Student student);

    List<ResponseStudentDTO> toResponseStudentDTOs(List<Student> students);

    Student toStudent(ResponseStudentDTO responseStudentDTO);
}
