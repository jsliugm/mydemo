package com.env;

import org.junit.Test;

/**
 * @program: MyDemo
 * @description: 环境变量
 * @author: guangming.liu
 * @create: 2018-08-16 17:52
 **/
public class EnvTest {
    @Test
    public void test(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperties());
        System.out.println(System.getenv().get("OS"));
    }
}