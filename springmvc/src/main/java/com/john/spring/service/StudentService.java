package com.john.spring.service;

import com.john.spring.bean.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    /**
     * 模拟从数据库按照id查询一条数据
     * @param id
     * @return
     */
    public Student queryStudentById(Integer id) {
        Student student = new Student();
        student.setId(id);
        student.setSname("张三");
        student.setAge(23);
        return student;
    }

}
