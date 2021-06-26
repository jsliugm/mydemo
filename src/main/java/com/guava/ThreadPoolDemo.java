package com.guava;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ThreadPoolDemo {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-rule-compiler-%d").build();
    private static ExecutorService taskExe = TtlExecutors.getTtlExecutorService(new ThreadPoolExecutor(40, 50, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory));
    private static ListeningExecutorService pool = MoreExecutors.listeningDecorator(taskExe);

    static void test() {
        // inheritableThreadLocal.set(1);
        List<ListenableFuture<Object>> futureList = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {
            final ListenableFuture<Object> future = pool.submit(() -> {
                Thread.sleep(100);
                return RuleContext.get();
            });

//            future.addListener(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        final String contents = future.get();
//                        System.out.println(contents);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, MoreExecutors.sameThreadExecutor());

            Futures.addCallback(future, new FutureCallback<Object>() {
                @Override
                public void onSuccess(Object result) {
                    //System.out.println(result);
                    //log.info("{}", result);
//                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable t) {
                    throw new RuntimeException(t);
                    // t.printStackTrace();
//                    countDownLatch.countDown();
                }
            });
            futureList.add(future);
        }
//        countDownLatch.await(3,TimeUnit.SECONDS);
        try {
            List<Object> list = Futures.successfulAsList(futureList).get();
            if(!StringUtils.equals(list.get(0).toString(),list.get(1).toString())) {
                log.info("{}",list);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        //log.info("over!!!!!!!");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    RuleContext.set(Thread.currentThread().getName());
                    test();
                }
            }).start();
        }
    }
}
