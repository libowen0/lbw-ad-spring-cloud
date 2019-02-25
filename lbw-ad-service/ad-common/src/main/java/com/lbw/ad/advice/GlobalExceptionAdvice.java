package com.lbw.ad.advice;

import com.lbw.ad.exception.AdException;
import com.lbw.ad.vo.CommonResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/22 Time: 11:34 Description:
 */

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request, AdException ex){
        CommonResponse<String> response = new CommonResponse<>(-1,"bussiness error");
        response.setDate(ex.getMessage());
        return response;
    }
}
