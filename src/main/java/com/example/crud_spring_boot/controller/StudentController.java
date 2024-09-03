package com.example.crud_spring_boot.controller;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ResponseStudentDTO> create(@RequestBody StudentDTO studentDTO) {
        ResponseStudentDTO student = studentService.create(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseStudentDTO>> getStudents() {
        List<ResponseStudentDTO> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}











