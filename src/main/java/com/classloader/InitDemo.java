package com.classloader;


/**
 * 通过子类引用父类静态变量不会触发子类初始化
 * @author universe
 */
public class InitDemo {
    public static void main(String[] args) {
        //1 通过子类引用父类静态变量不会触发子类初始化
        System.out.println(Child.address);
//        //2 通过数组引用类
//        Child[] children = new Child[10];
//        //3 访问常量
//        System.out.println(Child.name);
    }
}



