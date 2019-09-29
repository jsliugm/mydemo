package com.clazz;

import lombok.Data;

/**
 * Created by Administrator on 2017/8/18.
 */
@Data
public class Child extends Parent {
    private String name;

    public Child() {
        System.out.println("child constructor");
    }

/*    @Override
    public void print(){
        System.out.println(this.name);
        super.print();
    }*/
}
