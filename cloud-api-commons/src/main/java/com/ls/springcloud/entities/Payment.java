package com.ls.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author SGDBDS
 * @create 2020-05-17
 */
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
//使用后创建一个无参构造函数
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private  String serial;

}
