package com.john.spring.aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 通过注解配置AOP， 演示记录被代理方法调用日志功能
 */
@Slf4j
@Component
@Aspect
public class LoggerAspectJDemo {

    // 通过@Pointcut定义一个切入点， 切入点的名称就是方法名
    @Pointcut("execution(* com.john.spring.aop.annotation.Hello.*(..))")
    public void allMethod() {
    }

    // 用@Before定义一个前置通知， 参数表示引用allMethod()这个切入点
    @Before("allMethod()")
    public void beforeM() {
        log.debug("[beforeAdvice] 方法开始执行");
    }

    @Around("allMethod()")
    public Object aroundM(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("[aroundAdvice] "+joinPoint.getSignature().getName()+ "("+ Arrays.toString(joinPoint.getArgs()) +")方法开始执行");
        long start = System.currentTimeMillis();
        Object retVal = joinPoint.proceed();
//        int val = 9 / 0;    //模拟方法执行异常
        long time = System.currentTimeMillis() - start;
        log.debug("[aroundAdvice] "+joinPoint.getSignature().getName()+ "("+ Arrays.toString(joinPoint.getArgs()) +")方法执行结束，耗时: " + time + "ms.");
        return retVal;
    }

    @AfterReturning(value = "allMethod()", returning = "retVal")
    public void afterMReturn(Object retVal) {
        log.debug("[afterReturnAdvice] 方法执行结束， 返回值： " + retVal);
    }

    @AfterThrowing(value = "allMethod()", throwing = "throwable")
    public void afterMThrowing(Throwable throwable) {
        log.error("[afterThrowingAdvice] 方法执行出错", throwable);
    }

    @After("allMethod()")
    public void afterM() {
        log.debug("[afterAdvice] 方法执行结束");
    }

}
