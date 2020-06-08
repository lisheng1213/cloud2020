package com.ls.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //排除speingboot数据源
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageServiceApplication2002
{
    public static void main(String[] args)
    {
        SpringApplication.run(SeataStorageServiceApplication2002.class, args);
    }
}

