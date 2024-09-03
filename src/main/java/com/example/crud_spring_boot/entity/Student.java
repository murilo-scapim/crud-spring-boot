package com.example.crud_spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private Integer age;

    private double grade1;

    private double grade2;

    private double average;
}
