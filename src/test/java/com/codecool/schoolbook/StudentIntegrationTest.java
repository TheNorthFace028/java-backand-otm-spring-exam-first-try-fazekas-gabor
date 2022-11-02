package com.codecool.schoolbook;

import com.codecool.schoolbook.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.http.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private Integer port;

    @Autowired
    ApplicationContext context;

    private static Student[] STUDENTS;
    private String url;

    @BeforeEach
    void setup() {
        STUDENTS = new Student[]{
                new Student("ABCD", "Harry Potter", true, true, false),
                new Student("BCDE", "Ron", false, false, false),
                new Student("CDEF", "Hermione", true, true, true)

        };
        url = "http://localhost:" + port + "/student";
        resetRepos();
    }

    private void resetRepos() {
        final Map<String, Object> repos = context.getBeansWithAnnotation(Repository.class);
        repos.values().forEach(o -> {
            try {
                final Method clear = o.getClass().getMethod("clear", (Class<?>[]) null);
                clear.invoke(o);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    private HttpEntity<Student> createHttpEntityWithMediatypeJson(Student student) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(student, headers);
    }

    void postStudent(String url, Student student) {
        final HttpEntity<Student> httpEntity = createHttpEntityWithMediatypeJson(student);
        ResponseEntity<Void> response =  restTemplate.postForEntity(url, httpEntity, Void.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void givenEmptyDatabaseWhenGetAllStudentsRetrievedThenReturnsEmptyJsonList(){
        final String result = restTemplate.getForObject(url, String.class);
        assertEquals("[]", result);
    }

    @Test
    void givenNewStudentPostedWhenStudentRetrievedThenReturnsContent() {
        final Student[] result = restTemplate.getForObject(url, Student[].class);
        assertEquals(0, result.length);
        postStudent(url, STUDENTS[0]);
        final ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Student[] students = response.getBody();
        assertEquals(1, students.length);
        assertEquals(STUDENTS[0], students[0]);
    }

    @Test
    void getStudentWorks(){
        postStudent(url, STUDENTS[0]);
        final ResponseEntity<Student> response = restTemplate.getForEntity(url+"/"+ STUDENTS[0].getId(), Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Student student = response.getBody();
        assertEquals(STUDENTS[0], student);
    }

    @Test
    void updateStudentWorks(){
        postStudent(url, STUDENTS[0]);
        postStudent(url, STUDENTS[1]);
        restTemplate.put(url + "/" + STUDENTS[0].getId() + "?hasHistory=false&hasEnglish=false&hasMath=true", Void.class
        );
        final ResponseEntity<Student> response = restTemplate.getForEntity(url+"/"+ STUDENTS[0].getId(), Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Student Student = response.getBody();
        Student expectedStudent = new Student(STUDENTS[0].getId(), STUDENTS[0].getName(), false,false, true);
        assertEquals(expectedStudent, Student);
        final ResponseEntity<Student> responseOtherStudent = restTemplate.getForEntity(url+"/"+ STUDENTS[1].getId(), Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Student otherStudent = responseOtherStudent.getBody();
        assertEquals(STUDENTS[1],otherStudent);
    }

    @Test
    void deleteAllWorks(){
        postStudent(url, STUDENTS[1]);
        postStudent(url, STUDENTS[2]);
        final ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Student[] Students = response.getBody();
        assertEquals(2, Students.length);
        restTemplate.delete(url);
        final ResponseEntity<Student[]> responseAfterDelete = restTemplate.getForEntity(url, Student[].class);
        assertEquals(HttpStatus.OK, responseAfterDelete.getStatusCode());
        final Student[] StudentsAfterDelete = responseAfterDelete.getBody();
        assertEquals(0, StudentsAfterDelete.length);
    }
}
