package com.dzq.study.core.result;
/**
 * 描述:
 * 包名:com.dzq.study.core.result
 * 版本信息: 版本1.0
 * 日期:2021/3/19
 */


import com.dzq.study.core.exception.ExceptionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

import static com.dzq.study.core.constant.BaseConstant.SUCCESS_DEFAULT_CODE;
import static com.dzq.study.core.constant.BaseConstant.SUCCESS_DEFAULT_MSG;

/**
 * @describe：统一的返回对象
 * @version:v1.0
 * 2021/3/19 14:54  
 */
@Data
public class ApiResult<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 成功标志
     */
    private boolean success;
    /**
     * 消息描述
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    private Date date;

    public ApiResult() {
    }

    public ApiResult(Integer code, boolean success, String msg, T data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.date = new Date();
    }

    public ApiResult<T> success(T data){
        ApiResult result = new ApiResult();
        result.setCode(SUCCESS_DEFAULT_CODE);
        result.setMsg(SUCCESS_DEFAULT_MSG);
        result.setData(data);
        result.setSuccess(success);
        result.setDate(new Date());
        return result;
    }

    public static ApiResult error(Integer code, String msg) {
        ApiResult result = new ApiResult();
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        result.setDate(new Date());
        return result;
    }

    public static ApiResult error(ExceptionType type) {
        ApiResult result = new ApiResult();
        result.setCode(type.getCode());
        result.setSuccess(false);
        result.setMsg(type.getDescription());
        result.setDate(new Date());
        return result;
    }
}
