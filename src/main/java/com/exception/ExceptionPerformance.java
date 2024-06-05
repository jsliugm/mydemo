package com.exception;

import org.springframework.util.StopWatch;

public class ExceptionPerformance {
    public static void main(String[] args) {
        int n = 10000;

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = 9899;
                    int b = 0;
                    StopWatch sw = new StopWatch(Thread.currentThread().getName());
                    sw.start();
                    for (int i1 = 0; i1 < n; i1++) {
                        try {
                            a = a / b;
                        } catch (Exception e) {
                        }
                    }
                    sw.stop();
                    System.out.println(sw.prettyPrint());
                }
            }).start();
        }
    }
}
