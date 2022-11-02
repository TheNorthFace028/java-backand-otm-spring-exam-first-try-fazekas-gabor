package com.codecool.schoolbook.repository;

import com.codecool.schoolbook.model.Student;
import com.codecool.schoolbook.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate, StudentMapper studentMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentMapper = studentMapper;
    }

    public List<Student> getAll(){
        final String SQL = "SELECT id, name, has_history_book, has_english_book, has_math_book FROM STUDENT;";
        return jdbcTemplate.query(SQL, studentMapper);
    }
    public void add(Student student){
        final String SQL = "INSERT INTO STUDENT (id, name, has_history_book, has_english_book, has_math_book) VALUES (?, ?, ?, ?, ?);";
        Object[] args = new Object[]{
                student.getId(),
                student.getName(),
                student.getHasHistoryBook(),
                student.getHasEnglishBook(),
                student.getHasMathBook()
        };
        jdbcTemplate.update(SQL, args);
    }
    public Student getStudentById(String id){
        final String SQL = "SELECT id, name, has_history_book, has_english_book, has_math_book FROM STUDENT WHERE id = ?;";
        return jdbcTemplate.queryForObject(SQL, studentMapper, id);
    }

    public void updateStudent(boolean hasHistory, boolean hasEnglish, boolean hasMath, String id){
        String sql = "UPDATE STUDENT SET has_history_book = ?, has_english_book = ?, has_math_book = ? where id = ?;";
        jdbcTemplate.update(sql, hasHistory, hasEnglish, hasMath, id);
    }



    //do not modify this method, but you can use it.
    public void clear(){
        String clearSql = "DELETE FROM STUDENT;";
        jdbcTemplate.update(clearSql);
    }
}
