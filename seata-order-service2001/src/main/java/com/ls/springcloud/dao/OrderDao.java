package com.ls.springcloud.dao;

import com.ls.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
