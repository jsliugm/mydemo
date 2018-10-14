package com.clazz;

/**
 * Created by Administrator on 2017/8/18.
 */
public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    public Parent() {
        System.out.println("parent constructor");
    }

    public void test(){
        System.out.println(name);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.setName("test");
        child.test();
    }
}
