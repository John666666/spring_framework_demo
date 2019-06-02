package com.john.spring.dao;

import com.john.spring.bean.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> queryStudents() {
        System.out.println("查询学生列表");
        return new ArrayList<>();
    }
}
