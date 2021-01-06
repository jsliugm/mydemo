package com.map;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
public class MultiThreadDemo {
    private static Map<String,String> map = Maps.newHashMap();
    public static void main(String[] args) {
        //set thread
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        //Map<String,String> tmpMap = Maps.newHashMap();
                        map.put("name",Thread.currentThread().getName());
                        //map = tmpMap;
                    }
                }
            }).start();
        }
        //get thread
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        //map.get("name");
                        log.info(Integer.toHexString(map.hashCode()));
                    }
                }
            }).start();
        }
    }
}
