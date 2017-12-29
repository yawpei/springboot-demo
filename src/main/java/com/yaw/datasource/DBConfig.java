package com.yaw.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/12/29.
 */
@SpringBootConfiguration
public class DBConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource createDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        ds.setUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        return ds;
    }
}
