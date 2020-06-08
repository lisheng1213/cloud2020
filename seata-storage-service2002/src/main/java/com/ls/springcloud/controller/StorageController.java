package com.ls.springcloud.controller;

import com.ls.springcloud.domain.CommonResult;
import com.ls.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer num) {
        storageService.decrease(productId, num);
        return new CommonResult(200,"扣减库存成功！");
    }

}
