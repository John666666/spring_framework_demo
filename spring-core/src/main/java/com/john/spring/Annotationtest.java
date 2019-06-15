package com.john.spring;

import com.john.spring.bean.Student;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Getter
@Component
@Profile("product")  //指定该bean只在product profiles下才生效
//@Named
public class Annotationtest {

    @Autowired
    @Qualifier("stu1")
//    @Resource
    private Student stu1;

}
