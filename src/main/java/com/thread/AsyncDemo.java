package com.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.concurrent.*;

/**
 * Created by x250 on 2018/10/27.
 */
public class AsyncDemo {
    private static final Logger logger = LoggerFactory.getLogger(AsyncDemo.class);

    public static Future<String> test(String message, Long need) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(need);
                return message;
            }
        });
        return future;
    }
// push test
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("start....");
        Future<String> future1 = test("蒸饭", 1000L);
        // stopWatch.stop();
        // stopWatch.start("买菜");
        Future<String> future2 = test("买菜", 2000L);
        Thread.sleep(2000L);
        /// stopWatch.stop();
        //stopWatch.start("蒸饭print");
        System.out.println(future1.get());
        //stopWatch.stop();
        //stopWatch.start("买菜print");
        System.out.println(future2.get());
        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());
    }
}
