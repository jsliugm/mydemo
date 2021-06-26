package com.reflect;

public class A {
    static{
        System.out.println("A init");
        System.out.println(Thread.currentThread().getName());
    }
    public void foo(String name) {  
        System.out.println("Hello, " + name);  
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
} 