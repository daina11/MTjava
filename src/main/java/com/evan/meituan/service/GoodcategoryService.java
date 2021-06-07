package com.evan.meituan.service;

import com.evan.meituan.dao.GoodcategoryDao;
import com.evan.meituan.pojo.Goodcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GoodcategoryService {
    @Autowired
    GoodcategoryDao goodcategoryDao;

    public Goodcategory getByid(Integer id) {
        Goodcategory s = goodcategoryDao.findByIdEquals(id);
        return s;
    }

    /*查询首页顶部所有分类*/
    public Page getAll() {
        Page all = goodcategoryDao.findAll(PageRequest.of(0, 8));
        return all;
    }
}
