package com.dzq.study.core.exception;
/**
 * 描述:
 * 包名:com.dzq.study.core.exception
 * 版本信息: 版本1.0
 * 日期:2021/3/19
 */


import static com.dzq.study.core.constant.BaseConstant.SUCCESS_DEFAULT_CODE;
import static com.dzq.study.core.constant.BaseConstant.SUCCESS_DEFAULT_MSG;

/**
 * @describe：通用返回异常枚举
 * @version:v1.0
 * 2021/3/19 16:51  
 */
public enum CommonException implements ExceptionType {

    /**
     * 参数校验错误
     */
    PARAM_ERROR(ExceptionCodeLevel.PARAM.getValue(), "请求参数错误"),

    /**
     * 其他未知错误
     */
    OTHER_ERROR(ExceptionCodeLevel.OTHER.getValue(), "系统未知错误"),
    /**
     * 参数校验错误
     */
    PARAMETER_ERROR(ExceptionCodeLevel.CORE.getValue() + 1, "参数校验错误"),


    /**
     * 集合转树报错
     */
    MODULE_ROOT_PATH_ERROR(ExceptionCodeLevel.CORE.getValue() + 2, "get module root path error"),
    /**
     * feign 远程连接拒绝
     */
    FEIGN_CONNECTION_REFUSED(ExceptionCodeLevel.CORE.getValue() + 3, "feign rpc feign connection refused"),

    /**
     * inputstream 转文件报错
     */
    FILE_INPUTSTREAM2FILE_ERROR(ExceptionCodeLevel.OFFICE.getValue() + 4, "inputstream 2 file error"),

    /**
     * base64 请求参数是需要的
     */
    BASE64_PARAM_IS_REQUIRED(ExceptionCodeLevel.CORE.getValue() + 5, "base64 paramter is required"),

    /**
     * base64 编码不支持
     */
    BASE64_ENCODING_ERROR(ExceptionCodeLevel.CORE.getValue() + 6, "base64 encoding Unsupported"),

    /**
     * list 复制报错
     */
    BEAN_LIST_COPY_ERROR(ExceptionCodeLevel.CORE.getValue() + 7, "list bean copy error"),

    /**
     * map转bean报错
     */
    BEAN_MAP_2_BEAN_ERROR(ExceptionCodeLevel.CORE.getValue() + 8, "map transform to bean error"),

    /**
     * 集合转树报错
     */
    TREE_CONVERSION_ERROR(ExceptionCodeLevel.CORE.getValue() + 9, "collection 2 tree error"),

    /**
     * RoaringBitmap deserialize error
     */
    ROARING_BITMAP_DESERIALIZE_ERROR(ExceptionCodeLevel.CORE.getValue() + 10, "RoaringBitmap deserialize error"),

    /**
     * RoaringBitmap deserialize error
     */
    BASE64_STRING_2_ROARING_BITMAP_ERROR(ExceptionCodeLevel.CORE.getValue() + 11, "base64String 2 RoaringBitmap error"),

    /**
     * 参数转化错误
     */
    NUMBER_FORMAT_ERROR(ExceptionCodeLevel.CORE.getValue() + 12, "参数转化错误"),


    /**
     * bloom初始化位数太大
     */
    BLOOM_INIT_ERROR(ExceptionCodeLevel.CORE.getValue() + 13, "构造bloomfilter位数太大溢出了"),

    /**
     * 保存floom到文件报错
     */
    BLOOM_SAVE_ERROR(ExceptionCodeLevel.CORE.getValue() + 14, "保存bloomfilter到文件报错"),

    /**
     * 获得floom报错
     */
    BLOOM_GET_ERROR(ExceptionCodeLevel.CORE.getValue() + 15, "从文件获得bloomfilter报错"),


    /**
     * 构造ecdsa私钥报错
     */
    ECDSA_BUILD_PRIVATE_ERROR(ExceptionCodeLevel.CORE.getValue() + 16, "构造ecdsa私钥报错"),

    /**
     * 构造ecdsa私钥报错
     */
    ECDSA_BUILD_PUBLICH_ERROR(ExceptionCodeLevel.CORE.getValue() + 17, "构造ecdsa公钥报错"),

    /**
     * 构造ecdsa私钥报错
     */
    ECDSA_GET_SECRET_ERROR(ExceptionCodeLevel.CORE.getValue() + 18, "获得ecdsa密钥报错"),

    /**
     * 成功
     */
    SUCCESS(SUCCESS_DEFAULT_CODE, SUCCESS_DEFAULT_MSG);

    /**
     * 错误类型代码
     */
    private int code;

    /**
     * 错误类型描述
     */
    private String description;

    CommonException(int code,String description){
        this.code = code;
        this.description = description;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
