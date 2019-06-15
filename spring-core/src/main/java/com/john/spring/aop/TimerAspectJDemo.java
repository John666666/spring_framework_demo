package com.john.spring.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;


/**
 * 通过xml配置AOP， 演示统计被切入方法的执行时间
 */
@Slf4j
public class TimerAspectJDemo {

    public void beforeMethod() {
        log.debug("[beforeMethod] 开始执行方法");
    }

    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("[aroundAdvice] "+joinPoint.getSignature().getName()+ "("+ Arrays.toString(joinPoint.getArgs()) +")方法开始执行");
        long start = System.currentTimeMillis();
        Object retVal = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;
        log.debug("[aroundAdvice] "+joinPoint.getSignature().getName()+ "("+ Arrays.toString(joinPoint.getArgs()) +")方法执行结束，耗时: " + time + "ms.");
        return retVal;
    }

    public Object afterReturnMethod(Object retVal) {
        log.debug("[afterReturnMethod] 方法执行结束，返回值：" + retVal);
        return retVal;
    }

    public void afterMethod() {
        log.debug("[afterMethod] 方法执行结束");
    }


    public void afterThrowing(Throwable exception) {
        log.error("[afterThrowing] 方法执行出现异常", exception);
    }

}
