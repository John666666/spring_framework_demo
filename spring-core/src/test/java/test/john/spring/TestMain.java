package test.john.spring;

import com.john.spring.aop.Calc;
import com.john.spring.aop.annotation.Hello;
import com.john.spring.bean.ResourceInject;
import com.john.spring.bean.Student;
import com.john.spring.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.objenesis.strategy.StdInstantiatorStrategy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class TestMain {


    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private Calc calc;

    @Autowired
    private StudentDao studentDao;

    /**
     * 测试XML方式配置的声明式事务
     */
    @Test
    public void testAopTransactionByXML() {

        /*List<Student> studentList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            Student stu = new Student();
            if(i % 2 == 0) {
                stu.setSname("李云龙" + i);
                stu.setNickName("云龙兄" + i);
                stu.setGender("男");
            } else {
                stu.setGender("男");
                stu.setSname("楚云飞" + i);
                stu.setNickName("云飞兄" + i);
            }
            stu.setAge(i);
            studentList.add(stu);
        }

        int[] ids = studentDao.batchInsertStudent(studentList);

        System.out.println("插入成功：" + Arrays.toString(ids));*/

        List<Student> studentList = studentDao.queryStudents();
        System.out.println(studentList);
    }


    /**
     * 注入Resource类型属性
     */
    @Test
    public void testResourceDI() {
        ResourceInject ri = ctx.getBean(ResourceInject.class);
        System.out.println(ri.getResource());
    }


    /**
     * 测试XML配置AOP
     */
    @Test
    public void testAopByXML() {
        Calc calc = ctx.getBean(Calc.class);
        int result = calc.add(2, 7);
        System.out.println(result);


    }

    /**
     * 测试注解配置AOP
     */
    @Test
    public void testAopByAnnotation() {
        Hello hello = ctx.getBean(Hello.class);
        String result = hello.sayHello("John");
        System.out.println(result);
    }

}
