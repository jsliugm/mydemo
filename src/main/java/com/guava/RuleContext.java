package com.guava;

import com.alibaba.ttl.TransmittableThreadLocal;

public class RuleContext {
    private static ThreadLocal<Object> threadLocal = new TransmittableThreadLocal<>();


    public static void set(Object i) {
        threadLocal.set(i);

    }

    public static Object get() {
        return threadLocal.get();
    }
}
