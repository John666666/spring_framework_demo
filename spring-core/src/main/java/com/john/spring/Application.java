package com.john.spring;


import com.john.spring.dao.StudentDao;
import com.john.spring.service.StudentService;
import com.john.spring.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Import({MyConf.class})
@Configuration
public class Application {

    @Bean
    public StudentService studentService() {
//        System.out.println(dao);
        StudentService service = new StudentServiceImpl();
        return service;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("" +
//                "F:/applicationContext.xml");
        StudentService ss = ctx.getBean(StudentService.class);
        System.out.println(ss);
        ss.queryStudents();
    }

}
