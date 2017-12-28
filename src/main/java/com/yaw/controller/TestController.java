package com.yaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.IllegalFormatException;

/**
 * Created by Administrator on 2017/12/26.
 */
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "welcome";
    }

    @RequestMapping("/reg")
    public String reg(){
        throw  new IllegalArgumentException("arg is error");

    }
}
