package com.thread;

public class ThreadDemo {

    public static void main(String[] args) {

        new Thread(() -> {
            method1();
        }).start();

        new Thread(() -> {
            method2();
        }).start();
    }

    synchronized private static void method1() {
        try {
            Thread.sleep(1000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized private static void method2() {
        try {
            Thread.sleep(1000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
