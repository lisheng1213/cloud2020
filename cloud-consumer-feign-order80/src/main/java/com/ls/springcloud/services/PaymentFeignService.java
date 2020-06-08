package com.ls.springcloud.services;

import com.ls.springcloud.entities.CommonResult;
import com.ls.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author SGDBDS
 * @create 2020-05-25
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//eureka 上的服务名称
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}") //服务提供者中的具体服务
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
