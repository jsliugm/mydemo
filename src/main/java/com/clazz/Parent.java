package com.clazz;

import lombok.Data;

/**
 * Created by Administrator on 2017/8/18.
 */
@Data
public class Parent {
    private String name;

    public Parent() {
        System.out.println("parent constructor");
        this.name = "zhangsan";
    }
    public void print(){
        System.out.println(this.name);
    }
}
