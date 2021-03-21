package com.dzq.study.core.interceptor;
/**
 * 描述:
 * 包名:com.dzq.study.interceptor.config
 * 版本信息: 版本1.0
 * 日期:2021/3/7
 */


import com.dzq.study.core.anon.InterceptorBean;
import com.dzq.study.core.anon.Order;
import com.dzq.study.core.spring.SpringBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * @describe：拦截器默认注入配置文件
 * @version:v1.0
 * 2021/3/7 22:32  
 */
@Slf4j
@Configuration
public class InterceptorOrderConfig implements WebMvcConfigurer {

    /**
     * 将InterceptorBean注解的bean对象根据order进行排序后注入上下文
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        log.info("start config");
        //1.获取注解的拦截器
        Map<String, Object> myInterceptors = SpringBeanUtil.getBeansWithAnnotation(InterceptorBean.class);
        ArrayList<OrderEntity> handlers = new ArrayList<>();
        myInterceptors.forEach((e,v)->{
            if (v instanceof HandlerInterceptorAdapter){
                Class<? extends HandlerInterceptorAdapter> clazz = (Class<? extends HandlerInterceptorAdapter>) v.getClass();
                Order order = clazz.getAnnotation(Order.class);
                handlers.add(new OrderEntity(order.value(),e,(HandlerInterceptorAdapter) v));
            }
        });
        //2.排序
        Collections.sort(handlers, Comparator.comparingInt(OrderEntity::getOrder));
        //3.注入registry,设置匹配路径
        handlers.forEach(entity->{
            registry.addInterceptor(entity.getHandlerInterceptorAdapter()).addPathPatterns("/**");
            log.info(entity.getName());
        });

        log.info("end config");
    }

}
