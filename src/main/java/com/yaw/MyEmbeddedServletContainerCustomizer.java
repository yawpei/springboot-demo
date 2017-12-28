package com.yaw;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Administrator on 2017/12/28.
 * 指定Tomcat相关配置信息
 */
@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
        factory.setPort(9000);
        factory.setBaseDirectory(new File("e:/tomcat/log1/"));
        System.out.println(container.getClass());
    }
}
