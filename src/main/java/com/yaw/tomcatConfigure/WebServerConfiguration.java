package com.yaw.tomcatConfigure;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/12/26.
 * Tomcat配置方法二
 */
//@SpringBootConfiguration
public class WebServerConfiguration {
    @Bean
    public EmbeddedServletContainerFactory register() {
        TomcatEmbeddedServletContainerFactory factory =new TomcatEmbeddedServletContainerFactory();
        factory.setPort(10003);
        return factory;
    }
}
