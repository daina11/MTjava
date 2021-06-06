package com.evan.meituan.dao;

import com.evan.meituan.pojo.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderitemDao extends JpaRepository<Orderitem,Integer> {
        Orderitem findByGoodsidAndUidEquals(int gid,int uid);
}
