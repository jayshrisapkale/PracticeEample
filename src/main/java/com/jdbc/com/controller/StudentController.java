package com.jdbc.com.controller;

import com.jdbc.com.model.Student;
import com.jdbc.com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/students")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        try {
            studentRepository.save(new Student(student.getName(), student.getMobile()));
            return new ResponseEntity<>("Student was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Student student = studentRepository.findById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        try {
            int result = studentRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Student with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("student was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete student.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("updateStudent/{id}")
    public Student updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return studentRepository.updateStudent(student);
    }
}
