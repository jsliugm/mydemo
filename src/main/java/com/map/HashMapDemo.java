package com.map;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException {
        Map<Object, Object> map = new HashMap<Object, Object>(65);

        Class clazz = HashMap.class;

        for (Field f : clazz.getDeclaredFields()) {
            if (f.getName().equals("table")) {
                f.setAccessible(true);
                java.util.Map.Entry<Object, Object> entry[] = (java.util.Map.Entry<Object, Object>[]) (f
                        .get(map));
                System.out.println(entry.length);
            }
        }
    }

    @Test
    public void readOnlyTest() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "2");
        Map<String, String> ro = Collections.unmodifiableMap(map);

    }

    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", null);
        if (map.containsKey("a")) {
            System.out.println("xxxx");
        }
    }
}
