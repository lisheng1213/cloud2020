package com.ls.springcloud.service.impl;

import com.ls.springcloud.dao.PaymentDao;
import com.ls.springcloud.entities.Payment;
import com.ls.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SGDBDS
 * @create 2020-05-17
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
       return paymentDao.create(payment);
    };
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    };

}
