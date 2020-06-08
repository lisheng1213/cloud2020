package com.ls.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ls.springcloud.entities.CommonResult;

/**
 * @author SGDBDS
 * @create 2020-06-01
 */
public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");

    }


}
