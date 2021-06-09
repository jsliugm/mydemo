package com.guava;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

@Slf4j
public class ThreadPoolDemo {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-rule-compiler-%d").build();
    private static ExecutorService taskExe = new ThreadPoolExecutor(10, 20, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
    private static ListeningExecutorService pool = MoreExecutors.listeningDecorator(taskExe);

    public void test(Callable callable){
        List<ListenableFuture<Integer>> futureList = Lists.newArrayList();
    }

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(100);
        List<ListenableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            final ListenableFuture<Integer> future = pool.submit(() -> {
                Thread.sleep(1000 * 2);
                return finalI + 1000;
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

            Futures.addCallback(future, new FutureCallback<Integer>() {
                @Override
                public void onSuccess(Integer result) {
                    //System.out.println(result);
                    log.info("{}", result);
//                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable t) {
                    t.printStackTrace();
//                    countDownLatch.countDown();
                }
            });
            futureList.add(future);
        }
//        countDownLatch.await(3,TimeUnit.SECONDS);
        try {
            List<Integer> list = Futures.successfulAsList(futureList).get();
            log.info("{}", list);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        log.info("over!!!!!!!");
    }
}
