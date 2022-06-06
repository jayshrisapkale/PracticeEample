package com.jdbc.com.repository;

import com.jdbc.com.model.Student;

import java.util.List;

public interface StudentRepository {
    int save(Student student);

    Student findById(Long id);

    int deleteById(Long id);

    Student updateStudent(Student student);
}
