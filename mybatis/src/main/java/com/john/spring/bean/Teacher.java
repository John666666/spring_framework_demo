package com.john.spring.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class Teacher implements Serializable {
    private Integer id;
    private String tname;
    private List<Student> studentList;

    public Teacher() {
    }

    public Teacher(Integer id, String tname) {
        this.id = id;
        this.tname = tname;
    }

    public Teacher(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", studentList='" + studentList + '\'' +
                "}\n";
    }
}
