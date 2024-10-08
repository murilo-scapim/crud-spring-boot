package com.example.crud_spring_boot.controller;

import com.example.crud_spring_boot.dto.ResponseStudentDTO;
import com.example.crud_spring_boot.dto.StudentDTO;
import com.example.crud_spring_boot.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<EntityModel<ResponseStudentDTO>> create(
            @RequestBody StudentDTO studentDTO) {
        EntityModel<ResponseStudentDTO> student = studentService.create(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<ResponseStudentDTO>>> getStudents() {
        List<EntityModel<ResponseStudentDTO>> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<EntityModel<ResponseStudentDTO>>getStudentById(
            @PathVariable Long studentId) {
        EntityModel<ResponseStudentDTO> student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<EntityModel<ResponseStudentDTO>> update(@PathVariable Long studentId,
                                                     @RequestBody StudentDTO studentDTO) {
        EntityModel<ResponseStudentDTO> student = studentService.update(studentId, studentDTO);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
