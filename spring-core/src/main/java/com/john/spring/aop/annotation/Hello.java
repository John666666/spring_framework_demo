package com.john.spring.aop.annotation;


import org.springframework.stereotype.Component;

@Component
public class Hello {

    public String sayHello(String name) {
        String ret = "Hello, " + name;
        return ret;
    }

}
