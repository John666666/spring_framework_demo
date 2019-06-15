package test.john.spring;

import com.john.spring.aop.Calc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*: applicationContext.xml"})
public class TestMain {

    @Autowired
    private Calc calc;

    @Test
    public void testAop() {
        int result = calc.add(2, 7);
        System.out.println(result);
    }


}
