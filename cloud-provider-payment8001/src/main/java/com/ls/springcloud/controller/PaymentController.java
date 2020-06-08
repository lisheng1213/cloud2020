package com.ls.springcloud.controller;

import com.ls.springcloud.entities.CommonResult;
import com.ls.springcloud.entities.Payment;
import com.ls.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author SGDBDS
 * @create 2020-05-17
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody  Payment payment){
        int result = paymentService.create(payment);
        //log.info("*****插入结果："+result);
        System.out.println("获取自增id = " + payment.getId()+"内容 = " + payment.getSerial());
        if (result > 0) {
            return new CommonResult(200,"插入成功,serverPort="+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    };

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        //log.info("*****插入结果："+result);
        int i = 10/2;
        if (null == payment) {
            return new CommonResult(400,"获取失败 Id"+id,payment);
        }else{
            return new CommonResult(200,"获取成功,serverPort="+serverPort,payment);
        }
    };

    @GetMapping(value = "/payment/discover")
    public Object getDiscover(){
        //服务名
        List<String> servicse = discoveryClient.getServices();
        for (String str:servicse) {
            System.out.println("servicse = " + str);
        }
        //通过服务名CLOUD-PAYMENT-SERVICE 获取具体的服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ins:instances) {
            System.out.println("instances = "+ins.getServiceId()+"\t"+ins.getHost()+
                    "\t"+ins.getPort()+"\t"+ins.getUri() );
        }
        return this.discoveryClient;
    };

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }

}
