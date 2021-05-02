package com.evan.meituan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/a")
    public String a(){
        return "aaaa";
    }
}
