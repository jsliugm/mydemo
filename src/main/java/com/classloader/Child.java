package com.classloader;

public class Child extends Parent{

    public final static String name = "childname";

    static {
        System.out.println("child init");
    }
}