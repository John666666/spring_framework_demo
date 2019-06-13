package com.john.spring.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Student {
    private Integer id;
    private String sname;
    private Integer age;
    private String gender;
    private String nickName;


    public void init() {
        System.out.println("Student init...");
    }

    public void destroy() {
        System.out.println("Student destroy...");
    }

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

    public void setSname(String sname) {
        this.sname = sname;
    }
}
