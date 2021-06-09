package com.thread;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class ThreadDemo2 {
    private static volatile Map<String, List<String>> map = Maps.newHashMap();

    static {
        map.put("key1", Lists.newArrayList("value1"));
    }

    public static void main(String[] args) {
        // read
        new Thread(() -> {
            for (String value : map.get("key1")) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(value);
            }
        }).start();
        // write
        new Thread(() -> {
            Map<String, List<String>> map = Maps.newHashMap();
            ThreadDemo2.map = map;
        }).start();
    }
}
