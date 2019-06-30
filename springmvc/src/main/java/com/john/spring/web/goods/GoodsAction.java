package com.john.spring.web.goods;

import com.john.spring.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/goods") //DispatcherServlet的url-pattern已经配置成/goods/*了， 这里就不需要再配了，否则就需要访问/goods/goods/query才能访问到方法
public class GoodsAction {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/query")
    public ModelAndView queryGoods() {
        String msg = goodsService.queryGoods();
        System.out.println(msg);
        return new ModelAndView("main", "msg", msg);
    }

}
