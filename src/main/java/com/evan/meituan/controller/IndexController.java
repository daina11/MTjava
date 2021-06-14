package com.evan.meituan.controller;

import com.evan.meituan.pojo.Goodcategory;
import com.evan.meituan.pojo.Shop;
import com.evan.meituan.service.GoodslistService;
import com.evan.meituan.service.ShopService;
import com.evan.meituan.service.GoodcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
        首页的一些*/
@RestController
public class IndexController {
    @Autowired
    GoodcategoryService goodcategoryService;
    @Autowired
    GoodslistService goodslistService;
    @Autowired
    ShopService shopService;

    @PostMapping(value = "api/getShopcategoryByid")
    public Goodcategory getByid(@RequestBody Goodcategory sp) {
        int id = (int) sp.getId();
        Goodcategory s = goodcategoryService.getByid(id);
        return s;

    }

    /*查询首页顶部所有分类*/
    @PostMapping(value = "api/ShopCategoryAll")
    public Page getAll() {
        Page all = goodcategoryService.getAll();
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

   /* 搜索页面关键字查询商店*/
   @PostMapping(value = "api/getSearchShopsList")
   public Page getSearchShopsList(@RequestBody Map<String, Object> page) {
       /*用map来接收前端传来的page*/
       int p = (int) page.get("page");
       String kw = String.valueOf(page.get("keywords"));
       Page goodslist = shopService.getSearchByShopName("%"+kw+"%",p);
       return goodslist;

   }
    @PostMapping(value = "api/getShopinfo")
    public Shop getShopinfo(@RequestBody Map<String, Object> s) {
        int id = (int) s.get("id");

        return  shopService.getByid(id);

    }
}
