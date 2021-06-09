package com.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Volatile测试，当flag不加修饰符volatile时reader线程不会结束。
 */
@Slf4j
public class VolatileDemo {
    static int share = 10;
    static boolean flag = true;
    //volatile static Value value = new Value(true);

    public static void main(String[] args) {
        Value value = new Value(true);
        //reader
        new Thread(() -> {
            while (value.isValue()) {
                // System.out.println(flag);
                System.out.println("111111");
                value.isValue();
            }
        }).start();
        //writer
        new Thread(() -> {
            try {
                Thread.sleep(100L);
                //flag = false;
                value.setValue(false);
                System.out.println(value.isValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

