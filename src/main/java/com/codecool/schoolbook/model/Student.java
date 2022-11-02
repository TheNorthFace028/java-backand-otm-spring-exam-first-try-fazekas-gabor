package com.codecool.schoolbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private Boolean hasHistoryBook;
    private Boolean hasEnglishBook;
    private Boolean hasMathBook;
}
