package com.example.crud_spring_boot.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Data
public class ResponseStudentDTO {

    private Long id;

    private String fullName;

    private Integer age;

    private double grade1;

    private double grade2;

    private double average;
}
