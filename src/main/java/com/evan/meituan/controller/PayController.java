package com.evan.meituan.controller;

import com.evan.meituan.pojo.Orderitem;
import com.evan.meituan.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PayController {
    @Autowired
    OrderitemService orderitemService;

   /*
    通过uid和orderid查询未支付及购物车中的商品
    */
    @PostMapping(value = "api/getPayItem")
    public List<Orderitem> getPayItem(@RequestBody Map<String, Object> map) {
        int uid = (int)map.get("uid");
        List<Orderitem> item = orderitemService.getAllByUidAndStatis(uid,0);

        return item;
    }
}
