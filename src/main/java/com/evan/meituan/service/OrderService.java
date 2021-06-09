package com.evan.meituan.service;

import com.evan.meituan.dao.OrderDao;
import com.evan.meituan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    public void addOrder(Order order){
        orderDao.save(order);
    }
}
