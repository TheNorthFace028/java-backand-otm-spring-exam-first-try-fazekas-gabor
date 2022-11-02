package com.codecool.schoolbook.model.mapper;

import com.codecool.schoolbook.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getString("id"));
        student.setName(rs.getString("name"));
        student.setHasHistoryBook(rs.getBoolean("has_history_book"));
        student.setHasEnglishBook(rs.getBoolean("has_english_book"));
        student.setHasMathBook(rs.getBoolean("has_math_book"));
        return student;
    }
}
