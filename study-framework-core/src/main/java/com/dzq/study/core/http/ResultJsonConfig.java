package com.dzq.study.core.http;
/**
 * 描述:
 * 包名:com.dzq.study.datasource.config
 * 版本信息: 版本1.0
 * 日期:2021/3/13
 */


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @describe：配置http的消息转换器，设置编码格式以及返回json数据美化
 * @author: dengzq
 * @version:v1.0
 * 2021/3/13 19:20  
 */
@Configuration
public class ResultJsonConfig implements WebMvcConfigurer {

    private static final String CHARACTER_ENCODE_UTF8_UPPER = "UTF-8";

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(stringConverter());
        converters.add(fastConverter());
    }

    public HttpMessageConverter<String> stringConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName(CHARACTER_ENCODE_UTF8_UPPER));
        return converter;
    }

    public HttpMessageConverter fastConverter() {
        //1、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                //字符串null返回空字符串
                SerializerFeature.WriteNullStringAsEmpty,
                //数值类型为0
                SerializerFeature.WriteNullNumberAsZero,
                //空字段保留
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue);
        fastJsonConfig.setCharset(Charset.forName(CHARACTER_ENCODE_UTF8_UPPER));
        //2-1 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }
}
