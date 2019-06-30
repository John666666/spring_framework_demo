package com.john.spring.web.order;

import com.john.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class OrderAction {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/query")
    public ModelAndView queryOrders() {
        String msg = orderService.queryOrders();
        System.out.println(msg);
        return new ModelAndView("main", "msg", msg);
    }

}
