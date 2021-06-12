package com.evan.meituan.service;

import com.evan.meituan.dao.ShopDao;
import com.evan.meituan.pojo.Shop;
import com.evan.meituan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopDao shopDao;

    public boolean isExist(String username) {
        Shop shop = getByName(username);
        return null!=shop;
    }
    public Shop getByName(String username) {
        return shopDao.findByUsername(username);
    }
    /*首页商店页面加载*/
    public Page getIndexShopslist(int page){
        Page indexpage = shopDao.findAllByNameIsNotNull(PageRequest.of(page, 12));
        return indexpage;
    }

    public Page getSearchByShopName(String str,int page){
        Page l = shopDao.findAllByNameIsNotNullAndNameLike(str,PageRequest.of(page, 5));
        return l;
    }
    public void addShop(Shop shop){
        shopDao.save(shop);
    }
}
