package com.thread;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.Map;

@Slf4j
public class VolatitleDemo2 {
    static volatile int a;
    static int b;
    static Map<String, Object> map = Maps.newHashMapWithExpectedSize(10);

    static {
        map.put("c", "c");
    }

    public static void main(String[] args) {
    }

    @Test
    public void testWrite() {
        int n = 10000000;
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("nothing1");
        //int a = 0;
        for (int i = 0; i < n; i++) {
            //a = VolatitleDemo2.a;
        }
        stopWatch.stop();

        stopWatch.start("nothing2");
        //int a = 0;
        for (int i = 0; i < n; i++) {
            //a = VolatitleDemo2.a;
        }
        stopWatch.stop();

        stopWatch.start("b");
        for (int i = 0; i < n; i++) {
            b = 1;
        }
        stopWatch.stop();
        stopWatch.start("volatile");
        for (int i = 0; i < n; i++) {
            a = 1;
        }
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }


    @Test
    public void testRead() {
        int n = 10000000;
        StopWatch stopWatch = new StopWatch("");

        stopWatch.start("nothing1");
        //int a = 0;
        for (int i = 0; i < n; i++) {
            //a = VolatitleDemo2.a;
        }
        stopWatch.stop();

        stopWatch.start("nothing2");
        //int a = 0;
        for (int i = 0; i < n; i++) {
            //a = VolatitleDemo2.a;
        }
        stopWatch.stop();

        stopWatch.start("volatile");
        int a = 0;
        for (int i = 0; i < n; i++) {
            a = VolatitleDemo2.a;
        }
        stopWatch.stop();

        stopWatch.start("b");
        int b = 0;
        for (int i = 0; i < n; i++) {
            b = VolatitleDemo2.b;
        }
        stopWatch.stop();


        stopWatch.start("map");
        for (int i = 0; i < n; i++) {
            map.get("c");
        }
        stopWatch.stop();

        log.info(stopWatch.prettyPrint());
    }
}
