package com.evan.meituan.dao;

import com.evan.meituan.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsernameAndAndRole(String username,int role);
    User getByUsernameAndPasswordAndRole(String username,String password,int role);
}
