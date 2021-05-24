package com.evan.meituan.controller;

import com.evan.meituan.dao.ShopcategoryDao;
import com.evan.meituan.pojo.Result;
import com.evan.meituan.pojo.Shopcategory;
import com.evan.meituan.pojo.User;
import com.evan.meituan.service.ShopcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
        首页的一些*/
@RestController
public class IndexController {
    @Autowired
    ShopcategoryService shopcategoryService;

    @PostMapping(value = "api/h")
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
}
