package com.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadInterruptDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    try {
//                        Thread.sleep(8000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        log.info("isInterrupted: {}", Thread.currentThread().isInterrupted());
//                    }
                    log.info("哈哈");
                }
            }
        });
        t.start();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        t.interrupt();
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        System.out.println("结束了~~~");
    }
}
