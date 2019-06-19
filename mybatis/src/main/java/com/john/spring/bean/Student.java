package com.john.spring.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private Integer id;
    private String sname;
    private Integer age;
    private String gender;
    private String nickName;


    public Student() {
    }

    public Student(Integer id, String sname, Integer age) {
        this.id = id;
        this.sname = sname;
        this.age = age;
    }

    public Student(Integer id, String sname, Integer age, String gender, String nickName) {
        this.id = id;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", nickName='" + nickName + '\'' +
                "}\n";
    }
}
