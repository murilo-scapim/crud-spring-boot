package com.example.crud_spring_boot.utils;

import com.example.crud_spring_boot.controller.StudentController;
import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class HateoasHelper {

    public EntityModel<ResponseStudentDTO> addLinks(ResponseStudentDTO responseStudentDTO,
                                                    Long studentId) {
        return EntityModel.of(responseStudentDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class)
                        .getStudentById(studentId)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class)
                        .getStudents()).withRel("students")
        );
    }
}
