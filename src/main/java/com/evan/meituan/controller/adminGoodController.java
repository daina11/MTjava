package com.evan.meituan.controller;

import com.evan.meituan.pojo.*;
import com.evan.meituan.service.GoodslistService;
import com.evan.meituan.service.ShopService;
import com.evan.meituan.service.ShopgoodcategoryService;
import com.evan.meituan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class adminGoodController {
    @Autowired
    UserService userService;
    @Autowired
    ShopService shopService;
    @Autowired
    ShopgoodcategoryService shopgoodcategoryService;
    @Autowired
    GoodslistService goodslistService;
    /*添加商品分类*/
    @PostMapping(value = "api/addshopcategory")
    public RetResult<Shopgoodcategory> addShopCategory(@RequestBody Shopgoodcategory s) {
        String name = s.getName();
        int sid =s.getSid();
        Shopgoodcategory shopgoodcategory =new Shopgoodcategory();
        if (shopgoodcategoryService.getBynameAndSid(name,sid)!=null){
            return RetResponse.makeErrRsp("分类已存在！");
        }else {
            shopgoodcategory.setName(name);
            shopgoodcategory.setSid(sid);
            shopgoodcategoryService.addShopgoodCategory(shopgoodcategory);
            return RetResponse.makeOKRsp();
        }

    }
    /*添加商品*/
    @PostMapping(value = "api/addgood")
    public RetResult<Goodslist> addgood(@RequestBody Goodslist g) {
        goodslistService.addGoods(g);
        return RetResponse.makeOKRsp();
    }

    /*根据商品id查找商品实现编辑*/
    @PostMapping(value = "api/getgoodbyid")
    public RetResult<Goodslist> getgoodbyid(@RequestBody Map<String, Object> oi) {
        int id = (int) oi.get("id");
        Goodslist goodslist=goodslistService.getById(id);
        return RetResponse.makeOKRsp(goodslist);
    }
    /*编辑商品信息*/
    @PostMapping(value = "api/editgoodinfo")
    public RetResult<Goodslist> editgoodinfo(@RequestBody Goodslist g) {
        int id = g.getId();
        Goodslist goodslist=goodslistService.getById(id);
        goodslist.setName(g.getName());
        goodslist.setPrice(g.getPrice());
        goodslist.setGoodimg(g.getGoodimg());
        goodslist.setSid(g.getSid());
        goodslist.setStore(g.getStore());
        goodslist.setCid(g.getCid());
        goodslist.setScid(g.getScid());
        goodslistService.addGoods(goodslist);
        return RetResponse.makeOKRsp();
    }
    /*删除商品*/
    @PostMapping(value = "api/deletgood")
    public RetResult<Goodslist> deletgood(@RequestBody Map<String, Object> oi) {
        int id = (int) oi.get("id");
        goodslistService.deletByid(id);
        return RetResponse.makeOKRsp();
    }
}
