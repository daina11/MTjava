package com.evan.meituan.service;

import com.evan.meituan.dao.OrderitemDao;
import com.evan.meituan.pojo.Orderitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderitemService {
    @Autowired
    OrderitemDao orderitemDao;

    public void addOrderItem(Orderitem orderitem) {
        orderitemDao.save(orderitem);
    }

    public void deleteOrderItem(int id) {
        orderitemDao.deleteById(id);
    }

    public Orderitem getByGidAndUid(int g, int u) {
        return orderitemDao.findByGoodsidAndUidEquals(g, u);
    }

    public void deletBid(int id) {
        orderitemDao.deleteById(id);
    }

    public List<Orderitem> getAllByUid(int uid) {
        return orderitemDao.findAllByUid(uid);
    }
}
