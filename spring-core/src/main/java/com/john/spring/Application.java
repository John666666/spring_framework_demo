package com.john.spring;


import com.john.spring.aop.annotation.Hello;
import com.john.spring.bean.ResourceInject;
import com.john.spring.bean.Student;
import com.john.spring.service.StudentService;
import com.john.spring.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Import({MyConf.class})
@Configuration
/*@ComponentScan(
        value = "com.john.spring"
//        excludeFilters = @ComponentScan.Filter(Component.class)
    )*/
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
public class Application {

    @Bean
    @Lazy
    public StudentService studentService() {
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

        // 设置上下文profiles
        ctx.getEnvironment().setActiveProfiles("product");
        ctx.refresh();

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

        /*String url = ctx.getEnvironment().getProperty("jdbc.url");
        System.out.println("url: " + url);*/

        testAop(ctx);

    }

    private static void testDI(ApplicationContext ctx) {

        // 注入Resource类型属性
        ResourceInject ri = ctx.getBean(ResourceInject.class);
        System.out.println(ri.getResource());
    }


    private static void testAop(ApplicationContext ctx) {

        // 测试XML配置AOP
        /*Calc calc = ctx.getBean(Calc.class);
        int result = calc.add(2, 7);
        System.out.println(result);*/

        // 测试注解配置AOP
        Hello hello = ctx.getBean(Hello.class);
        String result = hello.sayHello("John");
        System.out.println(result);
    }

}
