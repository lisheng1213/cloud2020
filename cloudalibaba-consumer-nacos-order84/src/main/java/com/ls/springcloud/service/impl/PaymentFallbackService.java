package com.ls.springcloud.service.impl;

import com.ls.springcloud.entities.CommonResult;
import com.ls.springcloud.entities.Payment;
import com.ls.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author SGDBDS
 * @create 2020-06-01
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }

}
