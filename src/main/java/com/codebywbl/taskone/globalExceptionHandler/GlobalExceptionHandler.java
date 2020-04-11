package com.codebywbl.taskone.globalExceptionHandler;/*
    @author:bl
    @date:2020/04/02 9:58
    @description:
*/

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//全局捕获异常
@RestControllerAdvice(basePackages = "com.codebywbl.taskone.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)   //设置捕获指定的异常 // todo 尽量不要搞这种一劳永逸的异常捕获方式，题目要求，要根据特定的异常返回特定的结果
    public Map<String,Object> errorJSON(HttpServletResponse response,HttpServletRequest request, Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("URL",request.getRequestURL());
        map.put("statusCode",response.getStatus());
        map.put("errotMsg",e.getMessage());
        return map;
    }
}
