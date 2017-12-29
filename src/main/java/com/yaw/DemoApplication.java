package com.yaw;

import com.yaw.aop.AopTest;
import com.yaw.datasource.TestDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * spring.datasource.type 可以指定哪种数据源，默认支持tomcat (共Tomcat,Hikari,Dbcp,Dbcp2,Generic 五种）
 * jdbcTemplate，执行语句插入数据
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class DemoApplication {
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(DemoApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        /*
         * 数据库
         */
//        DataSource ds = context.getBean(DataSource.class);
//        Connection connection = ds.getConnection();
//       System.out.println(connection.getCatalog());
//        connection.close();
//        System.out.println(ds.getClass());
        // jdbcTemplate，执行语句插入数据
//        context.getBean(TestDao.class).excute("Mp3");
//        context.getBean(TestDao.class).excute1("Mp3","Mp4");
        /*
         *aop
         */
        context.getBean(AopTest.class).create("aaaa","12121");
    }
}
