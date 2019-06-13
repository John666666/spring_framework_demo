package com.john.spring;


import com.john.spring.bean.ResourceInject;
import com.john.spring.bean.Student;
import com.john.spring.methodinject.FruitPlate;
import com.john.spring.service.StudentService;
import com.john.spring.service.StudentServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import javax.sql.DataSource;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

//@Import({MyConf.class})
@Configuration
@ComponentScan(
        value = "com.john.spring"
//        excludeFilters = @ComponentScan.Filter(Component.class)
    )
//@PropertySource("classpath:jdbc.properties")
public class Application {

    @Bean
    public StudentService studentService(Annotationtest test) {
        System.out.println(test);
        StudentService service = new StudentServiceImpl();
        return service;
    }



    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("" +
//                "F:/applicationContext.xml");

        // 添加JVM关闭钩子，当程序运行结束时，IOC容器可以优雅的关闭
        ctx.registerShutdownHook();

//        ctx.getEnvironment().setActiveProfiles("test");
//        ctx.refresh();

        /*StudentService ss = ctx.getBean(StudentService.class);
        System.out.println(ss);
        ss.queryStudents();*/

        /*DataSource ds = ctx.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(ds);
        System.out.println(conn);*/

        /*StudentDao dao = ctx.getBean("stuDao1", StudentDao.class);
        System.out.println(dao);*/

        /*Annotationtest at = ctx.getBean(Annotationtest.class);
        Student stu = at.getStu1();*/

//        StudentService ss = ctx.getBean(StudentService.class);

        /*FruitPlate applePlate = ctx.getBean(FruitPlate.class);
        applePlate.getFruit();*/

//        Student stu1 =  ctx.getBean("stu1", Student.class);

        String url = ctx.getEnvironment().getProperty("jdbc.url");


        ResourceInject ri = ctx.getBean(ResourceInject.class);
        System.out.println(ri.getResource());

        System.out.println();

    }

}
