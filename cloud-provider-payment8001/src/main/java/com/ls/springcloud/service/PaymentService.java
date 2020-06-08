package com.ls.springcloud.service;

import com.ls.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author SGDBDS
 * @create 2020-05-17
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
