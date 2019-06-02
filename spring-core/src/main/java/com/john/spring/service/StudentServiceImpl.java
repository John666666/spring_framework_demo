package com.john.spring.service;

import com.john.spring.bean.Student;
import com.john.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> queryStudents() {
        return studentDao.queryStudents();
    }
}
