package com.evan.meituan.controller;

import com.evan.meituan.pojo.Orderitem;
import com.evan.meituan.pojo.Shopgoodcategory;
import com.evan.meituan.service.ShopgoodcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShopgoodcategoryController {
    @Autowired
    ShopgoodcategoryService shopgoodcategoryService;

    @PostMapping(value = "api/getSgCategory")
    public List<Shopgoodcategory> getSgCategory(@RequestBody Map<String, Object> map) {
            int sid = (int)map.get("sid");
        List<Shopgoodcategory> ls =shopgoodcategoryService.getShopgoodCategoryBysid(sid);
        return ls;
    }
}
