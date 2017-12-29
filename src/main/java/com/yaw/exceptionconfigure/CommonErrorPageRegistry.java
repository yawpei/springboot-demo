package com.yaw.exceptionconfigure;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/26.
 * 修改默认异常响应页面，当拦截对于异常时返回对应的jsp页面
 */
@Component
public class CommonErrorPageRegistry implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/jsp/400.jsp");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/jsp/500.jsp");
        ErrorPage arg = new ErrorPage(IllegalArgumentException.class,"/jsp/reg.jsp");
        registry.addErrorPages(e404,e500,arg);
    }
}
