package com.evan.meituan.service;

import com.evan.meituan.dao.OrderDao;
import com.evan.meituan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    public void addOrder(Order order){
        orderDao.save(order);
    }

    public List getOrederItem(int uid){
        List list = orderDao.findAllByUid(uid);
        return list;
    }
}
