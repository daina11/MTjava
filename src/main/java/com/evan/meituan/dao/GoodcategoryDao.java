package com.evan.meituan.dao;

import com.evan.meituan.pojo.Goodcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodcategoryDao extends JpaRepository<Goodcategory,Integer> {
    Goodcategory findByIdEquals(int id);
    Page<Goodcategory> findAll(Pageable pageable);
}
