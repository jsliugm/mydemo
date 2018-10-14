package com.thread;



import org.springframework.util.StopWatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: MyDemo
 * @description: future demo
 * @author: guangming.liu
 * @create: 2018-09-26 08:47
 **/
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("测试");
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
                return "abc";
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();
        //FutureTask<String> futureTask2 = new FutureTask<String>(callable);
       //new Thread(futureTask).start();
        Thread.sleep(800);
        if (!futureTask.isDone()) {
            System.out.println("task未完成");
        }
        System.out.println(futureTask.get());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}