package com.jdbc.com.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private String mobile;

    public Student(String name, String mobile) {
        this.name=name;
        this.mobile=mobile;
    }
}
