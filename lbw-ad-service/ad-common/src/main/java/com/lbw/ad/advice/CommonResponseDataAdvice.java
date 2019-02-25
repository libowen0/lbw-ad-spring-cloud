package com.lbw.ad.advice;

import com.lbw.ad.annotation.IgnoreResponseAdvice;
import com.lbw.ad.vo.CommonResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/22 Time: 10:42 Description:
 */

/**
 * 响应增强，自定义通用响应
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 响应是否支持拦截
     *
     * @param methodParameter 方法参数
     * @param aClass          类
     */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        // 注解存在与类上响应不包装
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 注解存在与方法上响应不包装
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    /**
     * 在写入响应之前操作
     */
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> aClass, org.springframework.http.server.ServerHttpRequest serverHttpRequest, org.springframework.http.server.ServerHttpResponse serverHttpResponse) {
        CommonResponse<Object> response = new CommonResponse<>(0,"");

        if(null == o){
            return response;
        }else if (o instanceof CommonResponse){
            response = (CommonResponse<Object>) o;
        }else {
            response.setDate(o);
        }
        return response;
    }
}
