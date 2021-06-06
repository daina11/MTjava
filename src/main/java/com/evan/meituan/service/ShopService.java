package com.evan.meituan.service;

import com.evan.meituan.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopDao shopDao;

    /*首页商店页面加载*/
    public Page getIndexShopslist(int page){
        Page indexpage = shopDao.findAll(PageRequest.of(page, 12));
        return indexpage;
    }
}
