package com.evan.meituan.controller;

import com.evan.meituan.pojo.Result;
import com.evan.meituan.pojo.User;
import com.evan.meituan.service.UserService;
import com.evan.meituan.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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
    String imgUrl;
    @PostMapping(value = "api/upavatar")

    public String avatarUpload(MultipartFile file) throws Exception{
//        String username = user.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        System.out.println(username);

        String folder = "D:/imgService";
        File imageFolder = new File(folder);

        //获取当前时间戳和随机数拼接避免重名
        String date = String.valueOf(new Date().getTime());

        //后面-4是保留文件后缀
        File f = new File(imageFolder, StringUtils.getRandomString(6)+date+ file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://image.mt.com/" + f.getName();

            //把图片链接赋值给全局变量
            imgUrl=imgURL;
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    /*修改头像*/
    @PostMapping(value = "api/editinfo")
    public User editInfo (@RequestBody User user){
        String username = user.getUsername() ;

        //把图片链接存储到数据库
        User  u= userService.getByName(username);
        u.setPhoto(imgUrl);
        //修改数据库
        userService.add(u);

        return u;
    }
    /*修改基本信息*/
    @PostMapping(value = "api/edinfoForm")
    public User edinfoForm (@RequestBody User user){
        String username = user.getUsername() ;
        int id  =user.getId();
        username = HtmlUtils.htmlEscape(username);

        if(userService.isExist(username)){

            return null;
        }else {
            User  u= userService.getById(id);
            u.setEmail(user.getEmail());
            u.setUsername(username);
            userService.add(u);
            return u;
        }

    }
}
