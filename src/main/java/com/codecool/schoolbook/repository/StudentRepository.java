package com.codecool.schoolbook.repository;

import com.codecool.schoolbook.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate, StudentMapper studentMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentMapper = studentMapper;
    }

    //do not modify this method, but you can use it.
    public void clear(){
        String clearSql = "DELETE FROM STUDENT;";
        jdbcTemplate.update(clearSql);
    }
}
