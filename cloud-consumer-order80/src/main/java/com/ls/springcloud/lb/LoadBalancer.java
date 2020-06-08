package com.ls.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author SGDBDS
 * @create 2020-05-24
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instances);
}
