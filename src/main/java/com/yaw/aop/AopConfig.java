package com.yaw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/29.
 *  实现AOP，
 *  1. 加入依赖，默认AOP已开启<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-aop</artifactId>
 </dependency>
  2. 创建Aspect，封装横切关注点（日志、监控等），需要配置通知（前置通知，后置通知等）和切入点（类、方法等）
  3. 将Aspect加入spring容器中
  4. 配置参数可以参加 AopAutoConfiguration.class
        默认基于JDK的动态代理来实现AOP（spring.aop.proxy-target-class=false并实现类，或者不配置）
        spring.aop.proxy-target-class=true 表示基于cglib
        或者配置flase但未实现类接口依然使用cglib
 */
@Component
@Aspect
public class AopConfig {
    @Before("execution(* com.yaw.aop..*.*(..))")
    public void log(){
        System.out.println(" before method");
    }

    @After("execution(* com.yaw.aop..*.*(..))")
    public void log(JoinPoint point){
        System.out.println("after method "+point.getTarget().getClass()+" ,args="+ Arrays.asList(point.getArgs()));
    }
}
