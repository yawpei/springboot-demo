package com.yaw.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;


/**
 * Created by Administrator on 2017/12/28.
 * 异常测试
 */
@RestController
public class ExceptionTestController {

/*
    // 只能对本类中所出现的异常做出处理
    @ExceptionHandler(value = Exception.class)
    public String error(Exception e){
        return "message is"+e.getMessage();
    }*/

    @RequestMapping("/error1")
    public String error1() throws FileNotFoundException {
        throw new FileNotFoundException("file not fund");
    }
    @RequestMapping("/error2")
    public String error2() throws ClassNotFoundException{
        throw new ClassNotFoundException("class not found");
    }
}
