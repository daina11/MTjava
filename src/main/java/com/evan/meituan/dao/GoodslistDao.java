package com.evan.meituan.dao;

import com.evan.meituan.pojo.Goodslist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodslistDao extends JpaRepository<Goodslist,Integer>{
    Goodslist findAllById(int id);
    Page<Goodslist> findAll(Pageable pageable);
    Page<Goodslist> findAllByCid(int cid,Pageable pageable);
}
