package com.wzw.springboot.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 一、后台异常获取
 */
@RestControllerAdvice
public class MyExceptionHandler {
    public static final String ERROR_VIEW ="error";

    //异常捕获封装
    @ExceptionHandler(value=Exception.class)
    public Object errorHandler (HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
        System.out.println("捕获到异常信息");
        e.printStackTrace();
       if(isAjax(request)) {//判断是否为ajax请求
       return  JsonResult.errorException(e.getMessage());
       }else {
           ModelAndView mav = new ModelAndView();
           mav.addObject("exception",e);
           mav.addObject("url",request.getRequestURL());
           mav.setViewName(ERROR_VIEW);
           System.out.println("message="+e.getMessage());
           System.out.println("url="+request.getRequestURL());
           return mav;
       }
    }

    // 判断是否是ajax请求
    public static boolean isAjax(HttpServletRequest httpRequest) {
        String xRequestedWith = httpRequest.getHeader("X-Requested-With");
        return (xRequestedWith != null && "XMLHttpRequest".equals(xRequestedWith));
    }
}
