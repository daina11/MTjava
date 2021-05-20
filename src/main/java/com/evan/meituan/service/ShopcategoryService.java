package com.evan.meituan.service;
import com.evan.meituan.dao.ShopcategoryDao;
import com.evan.meituan.pojo.Shopcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShopcategoryService {
    @Autowired
    ShopcategoryDao shopcategoryDao;
    public Shopcategory getByid(Integer id){
        Shopcategory s=shopcategoryDao.findByIdEquals(id);
        return s;
    }
}
