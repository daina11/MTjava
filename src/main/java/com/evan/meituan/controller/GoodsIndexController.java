package com.evan.meituan.controller;

import com.evan.meituan.pojo.Orderitem;
import com.evan.meituan.pojo.Result;
import com.evan.meituan.service.GoodslistService;
import com.evan.meituan.service.OrderitemService;
import com.evan.meituan.service.GoodcategoryService;
import net.sf.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GoodsIndexController {
    @Autowired
    GoodslistService goodslistService;
    @Autowired
    OrderitemService orderitemService;
    @Autowired
    GoodcategoryService goodcategoryService;

    /*
    根据分类来获取商品
    */
    @PostMapping(value = "api/getGoodsListBycid")
    public Page getGoodsBycid(@RequestBody Map<String, Object> ci) {
        /*用map来接收前端传来的page*/
        int c = (int) ci.get("cid");
        //System.out.println(c);
        int p = (int) ci.get("page");
        Page goodslist = goodslistService.getGoodsByCid(c, p);
        return goodslist;
    }


    /*
    存到购物车
    */
    @PostMapping(value = "api/insertOrderItem")
    public Result addOrderItem(@RequestBody Map<String, Object> oi) {
        try {
            JSONArray result = JSONArray.fromObject(oi.get("data"));
            //去掉空的
            JSONArray newresult = new JSONArray();
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).equals(null)) {

                } else {
                    newresult.add(result.get(i));
                }
            }

            //循环读取数组中的每条数据
            for (int i = 1; i < newresult.size(); i++) {
                //先把传过来的json数组转成json对象再转换成orderitem对象
                JSONObject jsonObject = JSONObject.fromObject(newresult.get(i));
                Orderitem o = (Orderitem) JSONObject.toBean(jsonObject, Orderitem.class);
                //uid和goodid存在时候修改  查询出该条数据获取id然后存储

                try {
                    Orderitem order = orderitemService.getByGidAndUid(o.getGoodsid(), o.getUid());
                    o.setId(order.getId());
                    orderitemService.addOrderItem(o);
                } catch (Exception e) {
                    orderitemService.addOrderItem(o);
                }
            }
        }catch (Exception e){

        }

        return new Result(200);
    }
}
