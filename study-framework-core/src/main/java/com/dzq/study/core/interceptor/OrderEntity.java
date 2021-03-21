package com.dzq.study.core.interceptor;
/**
 * 描述:
 * 包名:com.dzq.study.interceptor.config
 * 版本信息: 版本1.0
 * 日期:2021/3/7
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @describe：排序用实体对象
 * @version:v1.0
 * 2021/3/7 22:51  
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    /**
     * 拦截器排序
     */
    private int order;

    /**
     * 拦截器名称
     */
    private String name;

    /**
     *  拦截器
     */
    private HandlerInterceptorAdapter handlerInterceptorAdapter;
}
