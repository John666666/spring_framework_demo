package com.john.spring;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 此类专门用于定义公共的切入点表达式
 */
@Component
public class GlobalPointcuts {

    @Pointcut("execution(* com.john.spring.dao.*.*(..))")
    public void all_dao_method() {}

    @Pointcut("execution(* com.john.spring..*.*(..))")
    public void all_method() {}

    @Pointcut("args(int, String) && @args()")
    public void test() {}


}
