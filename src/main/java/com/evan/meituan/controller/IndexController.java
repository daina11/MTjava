package com.evan.meituan.controller;

import com.evan.meituan.pojo.Shopcategory;
import com.evan.meituan.service.GoodslistService;
import com.evan.meituan.service.ShopService;
import com.evan.meituan.service.ShopcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/*
        首页的一些*/
@RestController
public class IndexController {
    @Autowired
    ShopcategoryService shopcategoryService;
    @Autowired
    GoodslistService goodslistService;
    @Autowired
    ShopService shopService;

    @PostMapping(value = "api/getShopcategoryByid")
    public Shopcategory getByid(@RequestBody Shopcategory sp) {
        int id = (int) sp.getId();
        Shopcategory s = shopcategoryService.getByid(id);
        return s;

    }

    /*查询首页顶部所有分类*/
    @PostMapping(value = "api/ShopCategoryAll")
    public Page getAll() {
        Page all = shopcategoryService.getAll();
        return all;
    }

    /*首页商店列表*/
    @PostMapping(value = "api/getIndexGoodsList")
    public Page getIndexShopsList(@RequestBody Map<String, Object> page) {
        /*用map来接收前端传来的page*/
        int p = (int) page.get("page");
        Page goodslist = shopService.getIndexShopslist(p);
        return goodslist;

    }


}
