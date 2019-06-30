package com.john.spring.service;

import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    public String queryGoods() {
        return "查询所有商品";
    }

}
