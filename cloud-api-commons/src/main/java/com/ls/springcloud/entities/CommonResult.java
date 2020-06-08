package com.ls.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SGDBDS
 * @create 2020-05-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;
    private String message;
    private T data;



    //当data==null 调用此构造函数；次构造函数调用全参构造函数  data==null
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
