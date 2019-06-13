package com.john.spring.service;

import com.john.spring.bean.Student;
import com.john.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Nullable
    private StudentDao studentDao;

    public void init() {
        System.out.println("StudentService init...");
    }

    public void destroy() {
        System.out.println("StudentService destroy...");
    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.queryStudents();
    }
}
