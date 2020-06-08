package com.ls.springcloud.service;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer numcount);

}
