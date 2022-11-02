package com.codecool.schoolbook.controller;


import com.codecool.schoolbook.model.Student;
import com.codecool.schoolbook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }
    @PostMapping
    public void add(@RequestBody Student student) {
        service.add(student);
    }
    @GetMapping("{id}")
    public Student getStudentById(@PathVariable ("id") String id) {
        return service.getStudentById(id);
    }
    @PutMapping
    public void updateStudent(@RequestParam ("hasHistory") boolean hasHistory,
                              @RequestParam ("hasEnglish") boolean hasEnglish,
                              @RequestParam ("hasMath") boolean hasMath,
                              @RequestParam ("id") String id) {
        service.updateStudent(hasHistory, hasEnglish, hasMath, id);
    }
    @DeleteMapping
    public void clear() {
        service.clear();
    }
}
