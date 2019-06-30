package com.john.spring.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String queryOrders() {
        return "查询所有订单";
    }

}
