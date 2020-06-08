package com.ls.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@Mapper
public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("numcount") Integer numcount);

}
