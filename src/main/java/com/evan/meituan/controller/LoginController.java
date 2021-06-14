package com.evan.meituan.controller;

import com.evan.meituan.pojo.*;
import com.evan.meituan.service.ShopService;
import com.evan.meituan.service.UserService;
import com.evan.meituan.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    ShopService shopService;

    @PostMapping(value = "api/login")
    public User login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);


        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return null;
        } else {
            User u = userService.getByName(username);
            return u;
        }
    }

    @PostMapping(value = "api/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (userService.isExist(username)) {
            return new Result(400);
        } else {
            userService.add(user);
            return new Result(200);
        }

    }

    String imgUrl;

    @PostMapping(value = "api/upavatar")

    public String avatarUpload(MultipartFile file) throws Exception {
//        String username = user.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        System.out.println(username);

        String folder = "D:/imgService";
        File imageFolder = new File(folder);

        //获取当前时间戳和随机数拼接避免重名
        String date = String.valueOf(new Date().getTime());

        //后面-4是保留文件后缀
        File f = new File(imageFolder, StringUtils.getRandomString(6) + date + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://image.mt.com/" + f.getName();

            //把图片链接赋值给全局变量
            imgUrl = imgURL;
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*修改头像*/
    @PostMapping(value = "api/editinfo")
    public User editInfo(@RequestBody User user) {
        String username = user.getUsername();

        //把图片链接存储到数据库
        User u = userService.getByName(username);
        u.setPhoto(imgUrl);
        //修改数据库
        userService.add(u);

        return u;
    }

    /*修改基本信息*/
    @PostMapping(value = "api/edinfoForm")
    public User edinfoForm(@RequestBody User user) {
        String username = user.getUsername();
        int id = user.getId();
        username = HtmlUtils.htmlEscape(username);

        if (userService.isExist(username)) {

            return null;
        } else {
            User u = userService.getById(id);
            u.setEmail(user.getEmail());
            u.setUsername(username);
            userService.add(u);
            return u;
        }

    }

    /*商家注册*/
    @PostMapping(value = "api/adminregister")
    public Result adminregister(@RequestBody Shop shop) {
        String username = shop.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (shopService.isExist(username)) {
            return new Result(400);
        } else {
            shopService.addShop(shop);
            return new Result(200);
        }

    }

    /*商家登陆*/
    @PostMapping(value = "api/adminlogin")
    public RetResult<Shop> adminlogin(@RequestBody Shop requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);


        Shop shop = shopService.getByUsernameAndPassword(username, requestUser.getPassword());
        if (null == shop) {
            return RetResponse.makeOKRsp(shop);
        } else {
            Shop s = shopService.getByName(username);
            return RetResponse.makeOKRsp(s);
        }
    }

    /*商家封面上传*/
    @PostMapping(value = "api/shopimg")
    public RetResult<Shop> updateShopimg(@RequestBody Map<String, Object> s) {
        int id = (int) s.get("id");
        Shop shop = shopService.getByid(id);
        shop.setShopimg(imgUrl);
        shopService.addShop(shop);
        return RetResponse.makeOKRsp(shop);
    }

    /*商家信息编辑修改*/
    @PostMapping(value = "api/editshopinfo")
    public RetResult<Shop> editshopinfo(@RequestBody Shop shop) {
        int id = shop.getId();
        Shop shop1 = shopService.getByid(id);
        shop1.setLocation(shop.getLocation());
        shop1.setName(shop.getName());
        shopService.addShop(shop1);
        return RetResponse.makeOKRsp(shop1);
    }
}
