package com.john.spring.bean;

import lombok.Getter;
import lombok.Setter;
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
}
