package com.ls.springcloud.service.impl;

import com.ls.springcloud.dao.OrderDao;
import com.ls.springcloud.domain.Order;
import com.ls.springcloud.service.AccountService;
import com.ls.springcloud.service.OrderService;
import com.ls.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;
    @Resource
    StorageService storageService;
    @Resource
    AccountService  accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)//name 唯一
    public void create(Order order) {

         //创建订单
        log.info("----->开始新建订单");
        orderDao.create(order);

         //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getNum());
        log.info("----->订单微服务开始调用库存，做扣减end");

         //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

         //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");



    }
}
