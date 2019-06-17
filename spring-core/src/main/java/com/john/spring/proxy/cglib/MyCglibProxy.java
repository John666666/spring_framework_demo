package com.john.spring.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class MyCglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        enhancer.setUseCache(false);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("通过cglib代理，方法"+method.getName()+"开始执行……");
        //代理类对象实例调用父类方法
        Object retVal = methodProxy.invokeSuper(target, args);
        log.info("通过cglib代理，方法"+method.getName()+"执行结束");
        return retVal;


    }
}
