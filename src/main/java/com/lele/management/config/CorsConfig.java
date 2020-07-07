package com.lele.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
         * 跨域问题:
         * 1.当前服务端的所有请求
         * 2.允许的请求源端口
         * 3.允许的请求方式
         * 4.允许的请求头
         * 5.每次访问时,除去请求数据以外还会有一个探测(两次请求),
         *   探测请求的有效期内就不会再发送了(get没有探测)
         */
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
        System.out.println("aaa");
    }

}
