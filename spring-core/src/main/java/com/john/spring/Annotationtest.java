package com.john.spring;

import com.john.spring.bean.Student;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Named;

@Getter
//@Component
@Named
public class Annotationtest {

//    @Autowired
//    @Qualifier("stu1")
    @Resource
    private Student stu1;

}
