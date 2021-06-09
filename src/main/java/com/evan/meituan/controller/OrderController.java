package com.evan.meituan.controller;

import com.evan.meituan.pojo.Order;
import com.evan.meituan.pojo.Orderitem;
import com.evan.meituan.pojo.Result;
import com.evan.meituan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping(value = "api/addOrder")
    public Result addOrder(@RequestBody Map<String, Object> map) {
        int uid = (int)map.get("uid");
        String goodsid = (String) map.get("goodsid");

        long date = System.currentTimeMillis();
        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(date);
        System.out.println(sd);*/
        Order or = new Order();
        or.setUid(uid);
        or.setGoodsid(goodsid);
        or.setOrdertime(String.valueOf(date));
        orderService.addOrder(or);
        //把订单列表中的商品列表换成1
        return new Result(200);
    }
}
