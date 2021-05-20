package com.evan.meituan.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.*;


@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域，使用这种配置方法就不用在 interceptor 中再配置 header 了

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedOriginPatterns("*")//允许跨域访问的路径
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}