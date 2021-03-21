package com.dzq.study.core.interceptor;
/**
 * 描述:
 * 包名:com.dzq.study.interceptor.interceptor
 * 版本信息: 版本1.0
 * 日期:2021/3/7
 */


import com.dzq.study.core.anon.InterceptorBean;
import com.dzq.study.core.anon.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe：拦截器demo
 * @version:v1.0
 * 2021/3/7 23:04  
 */
@Order(1)
@InterceptorBean(name = "test1")
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(111);
        return true;
    }
}
