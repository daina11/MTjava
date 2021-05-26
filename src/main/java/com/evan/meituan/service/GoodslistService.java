package com.evan.meituan.service;

import com.evan.meituan.dao.GoodslistDao;
import com.evan.meituan.pojo.Goodslist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GoodslistService {
    @Autowired
    GoodslistDao goodslistDao;
    /*首页的商品列表分页加载*/
    public Page getIndexGoodslist(int page){
        Page indexpage = goodslistDao.findAll(PageRequest.of(page, 12));
        return indexpage;
    }
    public Goodslist getByid(){
        Goodslist gl = goodslistDao.findAllById(1);
        return gl;
    }
}
