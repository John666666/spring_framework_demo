package com.john.spring.methodinject;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 果盘
 */
@Component
public abstract class FruitPlate {

    /**
     * 每次从果盘中拿到的都是一个新的水果(实例)
     * @return
     */
    @Lookup("apple")
    public abstract Fruit getFruit();
}
