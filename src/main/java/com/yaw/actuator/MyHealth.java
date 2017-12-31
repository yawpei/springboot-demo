package com.yaw.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/31.
 * 自定义健康状态监测，实现HealthIndicator接口，并加入springboot容器
 */
@Component
public class MyHealth implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("error","test").build();
    }
}
