package com.we.fc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @author zdc
 * @since 2018-04-06 15:14
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("fc");
        druidDataSource.setPassword("123456");
        druidDataSource.setUrl("jdbc:mysql://47.104.144.238:6666/fc?characterEncoding=utf-8&useSSL=false&zeroDateTimeBehavior=convertToNull");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxActive(200);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(30 * 60 * 1000);
        druidDataSource.setQueryTimeout(5);
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setValidationQueryTimeout(3);
        System.out.println("正在初始化Druid...");
        druidDataSource.init();
        return druidDataSource;
    }
}
