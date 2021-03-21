package com.dzq.study.web;
/**
 * 描述:
 * 包名:com.dzq.study.web
 * 版本信息: 版本1.0
 * 日期:2021/3/20
 * Copyright 三合力通
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @describe：
 * @author: dengzq
 * @version:v1.0
 * 2021/3/20 17:16  
 */
@SpringBootApplication(scanBasePackages = "com.dzq.study")
public class FrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkApplication.class,args);
    }
}
