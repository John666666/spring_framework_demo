package com.john.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 通过注解的方式配置Spring声明式事务
 */
@Configuration
@EnableTransactionManagement
public class MyTransactionConf {
    /**
     * 定义TransactionManager bean
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
