package com.thread;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("hello");
        System.out.println(tl.get());
    }
}
