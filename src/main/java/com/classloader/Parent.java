package com.classloader;

public class Parent{
   final static String address = "xxxx";
    static{
        System.out.println("parent init");
    }
}