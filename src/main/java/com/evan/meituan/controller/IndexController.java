package com.evan.meituan.controller;

import com.evan.meituan.dao.ShopcategoryDao;
import com.evan.meituan.pojo.Result;
import com.evan.meituan.pojo.Shopcategory;
import com.evan.meituan.pojo.User;
import com.evan.meituan.service.ShopcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
        首页的一些*/
@RestController
public class IndexController {
        @Autowired
        ShopcategoryService shopcategoryService;
        @PostMapping(value = "api/h")
        public Shopcategory getByid(@RequestBody Shopcategory sp){
               int id= (int) sp.getId();
                System.out.println(11111);
                System.out.println(id);
                Shopcategory s =shopcategoryService.getByid(id);
                System.out.println(s);
                return s;

        }
        @PostMapping("/aa")
        public Shopcategory a(@RequestBody Shopcategory s){
                int id = s.getId();
                return shopcategoryService.getByid(id);
        }
}
