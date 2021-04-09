package com.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Volatile测试，当flag不加修饰符volatile时reader线程不会结束。
 */
@Slf4j
public class VolatileDemo {
    static int share = 10;
    static volatile boolean flag = true;

    public static void main(String[] args) {
        //reader
        new Thread(() -> {
            while (flag) {
                // System.out.println(share);
            }
        }).start();
        //writer
        new Thread(() -> {
            try {
                Thread.sleep(100L);
                flag = false;
                System.out.println(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

