package com.codecool.schoolbook.service;

import com.codecool.schoolbook.model.Student;
import com.codecool.schoolbook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository repository;
    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.getAll();
    }

    public void add(Student student) {
        repository.add(student);
    }

    public Student getStudentById(String id) {
        return repository.getStudentById(id);
    }

    public void updateStudent(boolean hasHistoryBook, boolean hasEnglishBook, boolean hasMathBook, String id) {
        repository.updateStudent(hasHistoryBook, hasEnglishBook, hasMathBook, id);
    }

    public void clear() {
        repository.clear();
    }
}
