package com.dzq.study.core.spring;
/**
 * 描述:
 * 包名:com.dzq.study.core.spring
 * 版本信息: 版本1.0
 * 日期:2021/3/19
 */


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @describe：注入的spring上下文对象，用于获取容器维护的bean对象
 * @version:v1.0
 * 2021/3/19 14:46  
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    /**
     * 获取上下文对象
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 获取bean
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 获取bean
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        checkApplicationContext();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 获取类型集合
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> requiredType) {
        checkApplicationContext();
        return applicationContext.getBeansOfType(requiredType);
    }

    /**
     * 获取所有被注解的 bean
     *
     * @param anno:
     * @throws
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> anno) {
        Map<String, Object> map;
        try {
            //获取注解的 bean
            map = getApplicationContext().getBeansWithAnnotation(anno);
        } catch (Exception e) {
            map = null;
        }
        return map;
    }

    /**
     * 清楚上下文对象
     */
    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    /**
     * 检验上下文对象
     */
    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext not inject, please define SpringContextHolder in applicationContext.xml");
        }
    }
}
