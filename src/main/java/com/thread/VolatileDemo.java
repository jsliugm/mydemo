package com.thread;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class VolatileDemo {
    private static Map<String, String> map = getMap();
    private static String value;

    static class Value{
         public volatile String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Value value = new Value();
        //writer
        Thread wt = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map=getMap();
                log.info("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnew {}",map.get("1") );
            }
        });
        wt.start();
        //reader
        Thread rt = new Thread(() -> {
            while (true) {
                String vv = map.get("1");
                if(vv.equals(value.getValue())) {
                    continue;
                }
                value.setValue(vv);
                log.info("map.get(1) = {}", vv);
            }
        });
        rt.start();

    }

    static int ii = 0;
    private static Map<String, String> getMap() {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(10);
        for (int i = 0; i < 10; i++) {
            map.put(i + "", ii+"---"+i);
        }
        ii++;
        return map;
    }

}

