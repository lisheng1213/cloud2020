package com.ls.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer num;

    private BigDecimal money;

    private Integer status; //订单状态：0：创建中；1：已完结

}
