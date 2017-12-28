package com.yaw;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.catalina.valves.Constants;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Administrator on 2017/12/28.
 * Tomcat配置方法一：指定Tomcat相关配置信息
 */
//@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
        factory.setPort(9000);
        factory.setBaseDirectory(new File("e:/tomcat/log1/"));
        factory.addContextValves(getAccessLogValve());
    }
    private AccessLogValve getAccessLogValve(){
        AccessLogValve accessLogValve = new AccessLogValve();
        accessLogValve.setDirectory("e:/tomcat/myLog");
        accessLogValve.setEnabled(true);
        accessLogValve.setPattern(Constants.AccessLog.COMMON_PATTERN);
        accessLogValve.setSuffix("springboot-accesslog-");
        accessLogValve.setPrefix(".txt");
        return accessLogValve;
    }
}
class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

    @Override
    public void customize(Connector connector) {
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setMaxConnections(1000);//设置最大连接数
        protocol.setMaxThreads(500);//设置最大线程数
    }
}
