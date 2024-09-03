package com.example.crud_spring_boot.dto;

import lombok.Data;

@Data
public class ResponseStudentDTO {

    private Long id;

    private String fullName;

    private Integer age;

    private double grade1;

    private double grade2;

    private double average;
}
