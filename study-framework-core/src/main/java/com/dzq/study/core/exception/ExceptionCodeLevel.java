package com.dzq.study.core.exception;
/**
 * 描述:
 * 包名:com.dzq.study.core.exception
 * 版本信息: 版本1.0
 * 日期:2021/3/19
 */


/**
 * @describe：异常代码枚举
 * @version:v1.0
 * 2021/3/19 16:55  
 */
public enum ExceptionCodeLevel {
    /**
     * 参数错误
     */
    PARAM(700),
    /**
     * 未知错误
     */
    OTHER(600),
    /**
     * 权限模块错误码范围
     */
    AUTHENTICATION(5000),
    /**
     * 缓存错误码范围
     */
    CACHE(6000),
    /**
     * 配置中心错误码范围
     */
    CONFIGSERVER(7000),
    /**
     * 基础模块错误码范围
     */
    CORE(8000),
    /**
     * 调度器错误码范围
     */
    JOB(9000),
    /**
     * 日志错误码范围
     */
    LOG(1000),
    /**
     * 消息队列错误码范围
     */
    MQ(3000),
    /**
     * 验证码
     */
    CAPTCHA(4000),
    /**
     * 运维发布
     */
    OPS(11000),
    /**
     * 存储
     */
    OSS(12000),

    /**
     * 基础模块错误码范围
     */
    DISPATCH(13000),


    /**
     * office
     */
    OFFICE(14000),
    /**
     * 路由
     */
    ROUTE(15000),

    /**
     * 检索
     */
    RETRIEVAL(16000),

    /**
     * 线程
     */
    POOL(17000),

    /**
     * ipfs
     */
    IPFS(18000),

    /**
     * db
     */
    DB(19000),
    /**
     * newsql
     */
    NEWSQL(21000),

    ;

    private Integer value;

    ExceptionCodeLevel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
