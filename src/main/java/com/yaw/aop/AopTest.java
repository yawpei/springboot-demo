package com.yaw.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/29.
 */
@Component
public class AopTest {
    public void create(String name ,String age){
        System.out.println("dog create");
    }
}
