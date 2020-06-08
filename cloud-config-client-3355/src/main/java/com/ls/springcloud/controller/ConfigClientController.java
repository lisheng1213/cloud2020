package com.ls.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

/**
 * @author SGDBDS
 * @create 2020-05-27
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.dev}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
