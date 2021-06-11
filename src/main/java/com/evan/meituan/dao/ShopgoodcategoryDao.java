package com.evan.meituan.dao;

import com.evan.meituan.pojo.Shopgoodcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopgoodcategoryDao extends JpaRepository<Shopgoodcategory,Integer> {
    List<Shopgoodcategory> findAllBySid(int sid);
}
