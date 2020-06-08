package com.ls.springcloud.controller;

import com.ls.springcloud.entities.CommonResult;
import com.ls.springcloud.entities.Payment;
import com.ls.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author SGDBDS
 * @create 2020-05-18
 */
@RestController
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private  RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class).getBody();

    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        //return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        ResponseEntity<CommonResult>  entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new CommonResult(400,"查询失败");
        }

    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        //通过服务名CLOUD-PAYMENT-SERVICE 获取具体的服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);//查看实现方法Ctrl+Alt+ 鼠标点击
        URI uri = instance.getUri();//Ctrl+Alt+b 出现返回值
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    };


}
