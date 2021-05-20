package com.evan.meituan.dao;

import com.evan.meituan.pojo.Shopcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopcategoryDao extends JpaRepository<Shopcategory,Integer> {
    Shopcategory findByIdEquals(int id);
}
