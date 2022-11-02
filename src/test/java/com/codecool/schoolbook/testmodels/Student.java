package com.codecool.schoolbook.testmodels;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private Boolean hasHistoryBook;
    private Boolean hasEnglishBook;
    private Boolean hasMathBook;

    public Student(String id, String name, Boolean hasHistoryBook, Boolean hasEnglishBook, Boolean hasMathBook) {
        this.id = id;
        this.name = name;
        this.hasHistoryBook = hasHistoryBook;
        this.hasEnglishBook = hasEnglishBook;
        this.hasMathBook = hasMathBook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasHistoryBook() {
        return hasHistoryBook;
    }

    public void setHasHistoryBook(Boolean hasHistoryBook) {
        this.hasHistoryBook = hasHistoryBook;
    }

    public Boolean getHasEnglishBook() {
        return hasEnglishBook;
    }

    public void setHasEnglishBook(Boolean hasEnglishBook) {
        this.hasEnglishBook = hasEnglishBook;
    }

    public Boolean getHasMathBook() {
        return hasMathBook;
    }

    public void setHasMathBook(Boolean hasMathBook) {
        this.hasMathBook = hasMathBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(hasHistoryBook, student.hasHistoryBook) && Objects.equals(hasEnglishBook, student.hasEnglishBook) && Objects.equals(hasMathBook, student.hasMathBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hasHistoryBook, hasEnglishBook, hasMathBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hasHistoryBook=" + hasHistoryBook +
                ", hasEnglishBook=" + hasEnglishBook +
                ", hasMathBook=" + hasMathBook +
                '}';
    }
}
