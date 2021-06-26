package com.reflect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
@Slf4j
public class TestClassLoad {
    private static void test() throws Exception {
        Class<?> clz = Class.forName("com.reflect.A");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        StopWatch stopWatch= new StopWatch();
        stopWatch.start("0---14");
        for (int i = 0; i < 32; i++) {
            log.info("{}",i);
            if(i==1){
                stopWatch.stop();
                stopWatch.start("15----");
            }
            m.invoke(o, Integer.toString(i));
        }
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(()->{
                if(finalI ==1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    test();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }  
}