package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//使用注解开发异常处理器
//声明该类是一个Controller的通知类，声明后该类就会被加载成异常处理器
//@ControllerAdvice
public class ExceptionAdvice {

    //类中定义的方法携带@ExceptionHandler注解的会被作为异常处理器，后面添加实际处理的异常类型
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map doNullException(Exception ex){
        Map map=new HashMap();
        map.put("error", "空指针类型");
        return map;
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String doArithmeticException(Exception ex){
        return "ArithmeticException";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map doException(Exception ex){
        Map map=new HashMap();
        map.put("error", "未知类型");
        return map;
    }

}
