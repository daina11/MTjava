package com.evan.meituan.service;

import com.evan.meituan.dao.ShopcategoryDao;
import com.evan.meituan.pojo.Shopcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcategoryService {
    @Autowired
    ShopcategoryDao shopcategoryDao;

    public Shopcategory getByid(Integer id) {
        Shopcategory s = shopcategoryDao.findByIdEquals(id);
        return s;
    }

    /*查询首页顶部所有分类*/
    public Page getAll() {
        Page all = shopcategoryDao.findAll(PageRequest.of(0, 8));
        return all;
    }
}
