package test.john.spring.proxy;

import com.john.spring.aop.Calc;
import com.john.spring.aop.CalcImpl;
import com.john.spring.aop.annotation.Hello;
import com.john.spring.proxy.cglib.MyCglibProxy;
import com.john.spring.proxy.jdk.MyDynamicProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void testJDKDynamicProxy() {
        Calc calc = new CalcImpl();
        MyDynamicProxy proxy = new MyDynamicProxy(calc);
        Calc calcProxy = (Calc) Proxy.newProxyInstance(calc.getClass().getClassLoader(), new Class[]{Calc.class}, proxy);
        calcProxy.add(34, 16);
    }

    @Test
    public void testCglibDynamicProxy() {
        MyCglibProxy cglibProxy = new MyCglibProxy();
        Hello hello = (Hello) cglibProxy.getProxy(Hello.class);
        System.out.println(hello.sayHello("John"));
    }
}
