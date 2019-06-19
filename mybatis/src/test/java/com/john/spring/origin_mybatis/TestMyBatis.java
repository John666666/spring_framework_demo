package com.john.spring.origin_mybatis;

import com.john.spring.bean.Student;
import com.john.spring.bean.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    MybatisTest mybatisTest = null;

    @Before
    public void setUp() {
        mybatisTest = new MybatisTest();
    }

    @Test
    public void testQueryStudent() {
        List<Student> studentList = mybatisTest.queryAllStudent();
        System.out.println(studentList);
    }

    @Test
    public void testInsertTeacher() {

        Teacher teacher = new Teacher("John");
        mybatisTest.insertTeacher(teacher);

    }

}
