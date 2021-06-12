package com.evan.meituan.dao;

import com.evan.meituan.pojo.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopDao extends JpaRepository<Shop,Integer> {
    Page<Shop> findAllByNameIsNotNull(Pageable pageable);
    Page<Shop> findAllByNameIsNotNullAndNameLike(String kw,Pageable pageable);
    Shop findByUsername(String username);
}
