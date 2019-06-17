package com.john.spring.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class MyDynamicProxy implements InvocationHandler {

    private Object target;
    public MyDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.debug("方法: " + method.getName()+"，开始执行");
        long start = System.currentTimeMillis();
        Object retVal = method.invoke(target, args);
        long timer = System.currentTimeMillis() - start;
        log.debug("方法: " + method.getName()+"，执行结束, 耗时: " + timer +"ms.");
        return retVal;
    }
}
