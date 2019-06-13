package com.john.spring.utils;

import com.john.spring.dao.StudentDao;
import com.john.spring.dao.StudentDaoImpl;
import com.john.spring.service.StudentService;
import com.john.spring.service.StudentServiceImpl;

public class FactoryUtil {

    public static StudentDao createStudentDao(String name) {
        return new StudentDaoImpl();
    }

    public Object createServiceImpl(String name) {
        if("stuDao".equals(name)) {
            return new StudentDaoImpl();
        } else if("stuService".equals(name)) {
            return new StudentServiceImpl();
        }
        return null;
    }

}
