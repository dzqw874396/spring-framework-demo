package com.dzq.study.controller;
/**
 * 描述:
 * 包名:com.dzq.study.controller
 * 版本信息: 版本1.0
 * 日期:2021/3/20
 * Copyright 三合力通
 */


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe：
 * @author: dengzq
 * @version:v1.0
 * 2021/3/20 17:23  
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test1")
    public String test(){
        return "test";
    }

    @GetMapping("test2")
    public int test2(){
        return 5/0;
    }
}
