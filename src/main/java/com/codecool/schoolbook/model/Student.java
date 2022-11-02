package com.codecool.schoolbook.model;

public class Student {

    String id;
    String name;
    Boolean hasHistoryBook;
    Boolean hasEnglishBook;
    Boolean hasMathBook;

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

}
