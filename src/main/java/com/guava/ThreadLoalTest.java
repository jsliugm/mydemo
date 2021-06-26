package com.guava;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ThreadLoalTest {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-rule-compiler-%d").build();
    private static ExecutorService taskExe = new ThreadPoolExecutor(2, 30, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10), namedThreadFactory);
    private static ListeningExecutorService pool = MoreExecutors.listeningDecorator(taskExe);
    private static InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();

}
