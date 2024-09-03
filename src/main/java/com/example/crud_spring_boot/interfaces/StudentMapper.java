package com.example.crud_spring_boot.interfaces;

import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);

    List<StudentDTO> toStudentDTOs(List<Student> students);

    Student toStudent(StudentDTO studentDto);
}
