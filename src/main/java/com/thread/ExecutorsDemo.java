package com.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by jsliu on 2019/3/21.
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.execute(() -> {
            while (true) {
                System.out.println("xxxxxxxxx");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.shutdown();//gracefully shutdown

        System.out.println("over");

    }
}
