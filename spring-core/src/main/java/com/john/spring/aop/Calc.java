package com.john.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Calc {

    public int add(int num1, int num2) {
        int result = num1 + num2;
        log.debug(num1 + " + " + num2 +" = " + result);
//        result = 9 / 0;   // 模拟方法出现异常
        return result;
    }

}
