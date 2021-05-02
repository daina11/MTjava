package com.evan.meituan.controller;

import com.evan.meituan.pojo.Result;
import com.evan.meituan.pojo.User;
import com.evan.meituan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
public class LoginController {
    @Autowired
    UserService userService;


    @PostMapping(value = "api/login")
    public User login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);


        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return null;
        } else {
           User  u = userService.getByName(username);
            return u;
        }
    }
    @PostMapping(value = "api/register")
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if(userService.isExist(username)){
            return new Result(400);
        }else {
            userService.add(user);
            return new Result(200);
        }

    }
    @PostMapping(value = "api/upavatar")
    public String avatarUpload(){
        String url="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg";
        return url;
    }
}
