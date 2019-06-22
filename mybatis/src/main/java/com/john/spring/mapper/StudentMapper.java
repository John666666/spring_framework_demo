package com.john.spring.mapper;

import com.john.spring.bean.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> queryAll();

    int insert(Student student);

    int insertBatch(List<Student> studentList);
}
