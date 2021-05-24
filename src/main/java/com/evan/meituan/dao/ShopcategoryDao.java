package com.evan.meituan.dao;

import com.evan.meituan.pojo.Shopcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopcategoryDao extends JpaRepository<Shopcategory,Integer> {
    Shopcategory findByIdEquals(int id);
    Page<Shopcategory> findAll(Pageable pageable);
}
