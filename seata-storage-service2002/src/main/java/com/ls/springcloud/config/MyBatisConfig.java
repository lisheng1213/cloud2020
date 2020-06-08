package com.ls.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@Configuration
@MapperScan({"com.ls.springcloud.dao"})
public class MyBatisConfig {
}
