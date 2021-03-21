package com.dzq.study.core.anon;
/**
 * 描述:
 * 包名:com.dzq.study.interceptor.anon
 * 版本信息: 版本1.0
 * 日期:2021/3/7
 * Copyright 三合力通
 */


import java.lang.annotation.*;

/**
 * @describe：拦截器排序对象
 * @author: dengzq
 * @version:v1.0
 * 2021/3/7 21:59  
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Order {

    int value() default 999;
}
