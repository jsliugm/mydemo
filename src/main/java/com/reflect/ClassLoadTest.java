package com.reflect;

public class ClassLoadTest {
    static {
        System.out.println("init");
        System.out.println(Thread.currentThread().getName());
    }

    static void test() {
        A a = new A();
        a.foo("xx");
    }

    public static void main(String[] args) {
        //mainLoad();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                test();
            }).start();
        }
    }
}
