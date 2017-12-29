package com.yaw.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2017/12/29.
 *
 * 使用template插入数据
 * @EnableTransactionManagement 开启事务 ，@Transactional事务控制
 * 注意：默认在运行时异常进行事务回滚，非运行时事务不回滚
 */
@Repository
@EnableTransactionManagement
public class TestDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void excute(String name) {
        String sql = "insert into table1(name) values('" + name + "')";
        jdbcTemplate.execute(sql);
    }

    /**
     * rollbackFor:指定某些类回滚
     * noRollbackFor: 指定某些类不回滚
     * @param names
     */
    @Transactional(noRollbackFor = FileNotFoundException.class)
    public void excute1(String ... names) throws Exception {
        for (String name:names) {
            String sql = "insert into table1(name) values('" + name + "')";
            jdbcTemplate.execute(sql);
            throw  new FileNotFoundException();
        }
    }
}
