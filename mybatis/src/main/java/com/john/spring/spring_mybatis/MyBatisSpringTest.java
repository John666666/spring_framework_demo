package com.john.spring.spring_mybatis;

import com.john.spring.bean.Student;
import com.john.spring.mapper.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyBatisSpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        StudentMapper studentMapper = ctx.getBean(StudentMapper.class);
        List<Student> studentList = studentMapper.queryAll();
        System.out.println(studentList);
    }
}
