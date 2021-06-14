package com.evan.meituan.service;

import com.evan.meituan.dao.ShopgoodcategoryDao;
import com.evan.meituan.pojo.Shopgoodcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopgoodcategoryService {
    @Autowired
    ShopgoodcategoryDao shopgoodcategoryDao;
    public List<Shopgoodcategory> getShopgoodCategoryBysid(int sid){
        return shopgoodcategoryDao.findAllBySid(sid);
    }
    public void addShopgoodCategory(Shopgoodcategory shopgoodcategory){
        shopgoodcategoryDao.save(shopgoodcategory);
    }
    public Shopgoodcategory getBynameAndSid(String name,int sid){
        return shopgoodcategoryDao.findByNameAndSid(name,sid);
    }
}
