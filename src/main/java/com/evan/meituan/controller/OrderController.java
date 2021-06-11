package com.evan.meituan.controller;

import com.evan.meituan.pojo.Order;
import com.evan.meituan.pojo.Orderitem;
import com.evan.meituan.pojo.Result;
import com.evan.meituan.service.OrderService;
import com.evan.meituan.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderitemService orderitemService;

    @PostMapping(value = "api/addOrder")
    public Result addOrder(@RequestBody Map<String, Object> map) {
        int uid = (int) map.get("uid");
        String goodsid = (String) map.get("goodsid");

        long date = System.currentTimeMillis();
        Order or = new Order();
        or.setUid(uid);
        or.setGoodsid(goodsid);
        or.setOrdertime(String.valueOf(date));
        orderService.addOrder(or);
        //把订单列表中的商品列表换成1
        String goodstr = goodsid.substring(0, goodsid.length() - 1);
        String gstr[] = goodstr.split(",");
        for (String k : gstr) {
            int gid = Integer.parseInt(k);
            List<Orderitem> orderitem = orderitemService.getAllByUidAndGoodidAndStatus(uid, gid, 0);
            for (Orderitem oor:orderitem
                 ) {
                oor.setStatus(1);
                orderitemService.addOrderItem(oor);
            }

        }
        return new Result(200);
    }

    /*
    通过order中的商品id查询订单中的商品
    */
    @PostMapping(value = "api/getOrderItem")
    public List orderDetail(@RequestBody Map<String, Object> m) {
        int uid = (int) m.get("uid");
        //查询用户的订单
        List l = orderService.getOrederItem(uid);
        //查询订单中存在的商品
        List t = new ArrayList();
        for (int i = 0; i < l.size(); i++) {
            Order o = (Order) l.get(i);
            String goodstr = o.getGoodsid().substring(0, o.getGoodsid().length() - 1);
            String gstr[] = goodstr.split(",");
            String str = "";
            for (String k : gstr) {
                Map<String, String> one = new HashMap();
                one.put("orderid", String.valueOf(o.getId()));
                int gid = Integer.parseInt(k);
                List<Orderitem> oit = orderitemService.getAllByUidAndGoodidAndStatus(uid, gid, 1);
                for (Orderitem orr:oit
                     ) {
                    str += orr.getGoodname() + "*" + orr.getGoodsnumber() + "  " + "一共" + orr.getGoodsamout() + "元" + "   ";
                }

            }
            t.add(str);
        }
        
        return t;
    }
}
