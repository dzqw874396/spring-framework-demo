package com.dzq.study.core.exception;
/**
 * 描述:
 * 包名:com.dzq.study.core.exception
 * 版本信息: 版本1.0
 * 日期:2021/3/19
 */


/**
 * @describe：统一异常类型接口
 * @version:v1.0
 * 2021/3/19 14:56  
 */
public interface ExceptionType {

    /**
     * 获取错误类型代码
     * @return
     */
    int getCode();

    /**
     * 获取错误描述
     * @return
     */
    String getDescription();
}
