package com.wzw.springboot.util;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 二、ajax异常获取
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {
    //@ExceptionHandler(value=Exception.class)
    public JsonResult errorHandler (HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
        System.out.println("ajax异常捕获");
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }

}
