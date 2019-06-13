package com.john.spring.methodinject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Banana extends Fruit {

    public Banana() {
        System.out.println("Banana construct!");
    }
}
