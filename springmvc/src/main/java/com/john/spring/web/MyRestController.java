package com.john.spring.web;

import com.john.spring.bean.Student;
import com.john.spring.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest_api")
public class MyRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/get/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        log.debug("getStudent by id: " + id);
        return studentService.queryStudentById(id);
    }

}
