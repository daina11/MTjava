package com.evan.meituan.service;
import com.evan.meituan.dao.UserDAO;
import com.evan.meituan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }
    public User getById(Integer id){
//       findById(String id).get();2.x.x版本后需要.get()才能得到实体对象，注意 id未查询到对应实体时会报错
//        加.orElse(null)找不到数据会返回null
        return userDAO.findById(id).orElse(null);
    }

    public User getByName(String username) {
        return userDAO.findByUsernameAndAndRole(username,0);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPasswordAndRole(username, password,0);
    }

    public void add(User user) {
        userDAO.save(user);
    }
}
