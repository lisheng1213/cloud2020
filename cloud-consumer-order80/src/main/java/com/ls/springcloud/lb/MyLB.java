package com.ls.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SGDBDS
 * @create 2020-05-24
 */
@Component
public class MyLB implements LoadBalancer{//Ctrl+i 出现实现方法

    //接口调用次数 初始值==0
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取服务实例
    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement()%instances.size();
        return instances.get(index);
    }

    //获取访问次数 自旋+CAS
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE ? 0: current+1;
          /*使用CAS判断  如果当前值==内存值  将修改值(next)写入内存 并返回true  使用! 则为flase
            跳出循环  如果为flase则继续循环（自旋）*/
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第****** "+next+" *******访问");
        return next;
    };
}
