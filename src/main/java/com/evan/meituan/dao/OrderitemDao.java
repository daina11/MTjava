package com.evan.meituan.dao;

import com.evan.meituan.pojo.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderitemDao extends JpaRepository<Orderitem,Integer> {
        Orderitem findByGoodsidAndUidEquals(int gid,int uid);
        List<Orderitem> findAllByUid(int uid);
        Orderitem deleteById(int id);
        List<Orderitem> findAllByUidAndStatus(int uid ,int s);
        List<Orderitem> findAllByUidAndGoodsidAndStatus(int uid,int gid,int s);

}
