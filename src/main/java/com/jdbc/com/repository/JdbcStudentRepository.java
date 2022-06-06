package com.jdbc.com.repository;

import com.jdbc.com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcStudentRepository implements StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Student student) {
        return jdbcTemplate.update("INSERT INTO student (name, mobile) VALUES(?,?)",
                new Object[]{student.getName(), student.getMobile()});
    }

    @Override
    public Student findById(Long id) {
        try {
            Student student = jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Student.class), id);
            return student;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
    }

    @Override
    public Student updateStudent(Student student) {
        jdbcTemplate.update("UPDATE STUDENT SET MOBILE=? WHERE ID=?", student.getMobile(), student.getId());
        return student;
    }



}
