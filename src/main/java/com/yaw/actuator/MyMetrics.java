package com.yaw.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/12/31.
 * CounterService:用来计数的服务，可以直接使用
 * GaugeService：用来统计某个值的服务，可以直接使用
 */
@Controller
public class MyMetrics {
    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;

    @GetMapping("/testCount")
    public String testCount(){
        counterService.increment("test count num");
        return "welcome";
    }

    @GetMapping("/testGauge")
    public String testGauge(@RequestParam("price") double price){
        gaugeService.submit("price name is ",price);
        return "welcome";
    }
}
