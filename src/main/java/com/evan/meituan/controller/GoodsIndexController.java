package com.evan.meituan.controller;

import com.evan.meituan.service.GoodslistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GoodsIndexController {
    @Autowired
    GoodslistService goodslistService;

    @PostMapping(value = "api/getGoodsListBycid")
    public Page getGoodsBycid(@RequestBody Map<String, Object> ci) {
        /*用map来接收前端传来的page*/
        int c = (int) ci.get("cid");
        //System.out.println(c);
        int p =(int) ci.get("page");
        Page goodslist = goodslistService.getGoodsByCid(c,p);
        return goodslist;
    }
}
