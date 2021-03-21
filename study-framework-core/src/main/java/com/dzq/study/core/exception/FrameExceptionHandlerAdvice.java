package com.dzq.study.core.exception;
/**
 * 描述:
 * 包名:com.dzq.study.core.exception
 * 版本信息: 版本1.0
 * 日期:2021/3/21
 * Copyright 三合力通
 */


import com.alibaba.fastjson.JSON;
import com.dzq.study.core.constant.BaseConstant;
import com.dzq.study.core.result.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @describe：统一的异常处理，返回对象
 * @version:v1.0
 * 2021/3/21 12:19  
 */
@RestControllerAdvice
@ControllerAdvice
public class FrameExceptionHandlerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrameExceptionHandlerAdvice.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public void handle(HttpServletRequest request, HttpServletResponse res, NoHandlerFoundException e) {
        LOGGER.error("NoHandlerFoundException类型的错误:{}", e);
        String msg = e.getLocalizedMessage();
//        Integer status = getCodeByErrorMsg(msg);
        int status = BaseConstant.ERROR_NOT_FOUND;
        res.setStatus(HttpStatus.CONFLICT.value());
        responsePrint(res, status, msg);
    }

    /**
     * 最外层捕获
     * @param request
     * @param res
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public ApiResult handle(HttpServletRequest request, HttpServletResponse res, Exception e) {
        LOGGER.error("其他错误，Exception类型的错误:{}", e);
            res.setStatus(HttpStatus.CONFLICT.value());
        return ApiResult.error(CommonException.OTHER_ERROR.getCode(), CommonException.OTHER_ERROR.getDescription());
    }

//    private Integer getCodeByErrorMsg(String msg) {
//        if (msg.startsWith("404")) {
//            return HttpStatus.NOT_FOUND.value();
//        } else {
//            return CommonException.OTHER_ERROR.getCode();
//        }
//    }

    private void responsePrint(ServletResponse response, Integer status, String message) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(status);
        apiResult.setSuccess(false);
        apiResult.setMsg(message);
        apiResult.setDate(new Date());
        String json = JSON.toJSONString(apiResult);
        try {
            httpResponse.getWriter().print(json);
        } catch (IOException e) {
            LOGGER.error("其他错误处理response返回处理报错：{}", e);
        }
    }
}
