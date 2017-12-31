package com.yaw.actuator;

import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

/**
 * Created by Administrator on 2017/12/31.
 * Metric 不仅可以输出到浏览器，也可以输出到Jvm，redis 等
 * 通过向spring容器中装配一个MetricWriter来实现定向输出
 */
@Configuration
public class ExportConfig {

    @Bean
    @ExportMetricWriter
    public MetricWriter createMetricWriter(MBeanExporter mBeanExporter){
        return new JmxMetricWriter(mBeanExporter);
    }
}
