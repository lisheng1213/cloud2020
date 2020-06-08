package com.ls.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ls.springcloud.entities.CommonResult;
import com.ls.springcloud.entities.Payment;
import com.ls.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SGDBDS
 * @create 2020-06-01
 */
@RestController
public class RateLimitController {
    // 使用自定义的兜底方法 handleException  该handleException方法只针对sentinel中配置的流控规则起效
    //代码运行中出出现的问题不管用  任然走sentinel的兜底方法
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    // 使用sentinel的兜底方法
    @GetMapping("/retaLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    //问题   兜底方法与业务方法耦合   一个业务方法一个兜底方法  代码膨胀
    @GetMapping("/retaLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,  //兜底方法所在类
            blockHandler = "handlerException1")//具体哪个方法
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }

}
