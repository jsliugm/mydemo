package com.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapDemo {
    @Test
    public void test() {
        TreeMap map=new TreeMap();
        for (int i = 0; i < 100; i++) {
            map.put("key"+i,"bb"+i);
        }
        String json = JSON.toJSONString(map);
        System.out.println(json);
        TreeMap map2 = JSONObject.parseObject(json,TreeMap.class);
        map2.put("key1","cc");
        String json2 = JSON.toJSONString(map2);
        System.out.println(json2);
    }
    @Test
    public void test2() {
        HashMap map=new HashMap();
        for (int i = 0; i < 100; i++) {
            map.put("key"+i,"bb"+i);
        }
        String json = JSON.toJSONString(map);
        System.out.println(json);
        HashMap map2 = JSONObject.parseObject(json,HashMap.class);
        map2.put("key1","cc");
        String json2 = JSON.toJSONString(map2);
        System.out.println(json2);
    }

    @Test
    public void test3() {
        String json = "{time:"+System.currentTimeMillis()+"}";
        JSONObject map2 = JSONObject.parseObject(json);
        Object time = map2.get("time");
        System.out.println("xxx");
    }
}
