package com.john.spring.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Integer id;
    private String sname;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }
}
