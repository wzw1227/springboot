package com.wzw.springboot.util;

/*数据封装类
* 该类将数据装换成所需数据类型格式
* 200:标识成功
* 500：标识错误，错误信息在msg中
* 501：bean验证错误，不管多少错误都以map形式返回
* 502：拦截器拦截到token出错
* 555：异常抛出信息
* */

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResult {

    //定义Jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //响应业务状态
    private Integer status;
    //响应消息
    private String msg;
    //响应数据
    private Object data;

    public static JsonResult build(Integer status,String msg,Object data){

        return new JsonResult(status, msg, data);
    }

    public static  JsonResult ok(){
        return new JsonResult(null);
    }

    public static  JsonResult ok(Object data){
        return new JsonResult(data);
    }

    public static  JsonResult errorMsg(String msg){
        return new JsonResult(500,msg,null);
    }

    public static  JsonResult errorMap(Object data){
        return new JsonResult(501,"error",data);
    }

    public static  JsonResult errorTokenmsg(String msg){
        return new JsonResult(502,msg,null);
    }

    public static  JsonResult errorException(String msg){
        return new JsonResult(555,msg);
    }


    //==========================================================//
    public JsonResult() {
    }

    public JsonResult(Object data) {
        this.status=200;
        this.msg="ok";
        this.data=data;
    }

    public JsonResult(Integer status,String msg) {

        System.out.println(status+"===="+msg);
        this.status=status;
        this.msg=msg;
    }

    public JsonResult(Integer status,String msg,Object data) {
        this.status=status;
        this.msg=msg;
        this.data=data;
    }

    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
