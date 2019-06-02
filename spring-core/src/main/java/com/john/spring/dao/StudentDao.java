package com.john.spring.dao;

import com.john.spring.bean.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryStudents();
}
