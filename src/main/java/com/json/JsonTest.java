package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jsliu on 2018/7/23.
 */
public class JsonTest {
    static String arrayJason;

    @Test
    public void test() {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "zhangsan");
        hashMap.put("age", "10");
        System.out.println(JSONObject.toJSON(hashMap));
    }

    //@Before
    public void before() {
        List<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            dataList.add("testStr" + i);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataList", dataList);
        arrayJason = JSON.toJSON(map).toString();
        System.out.println(arrayJason);
    }

    @Test
    public void test2ArrayToLinkedList() {
        JsonData jsonData = JSONObject.parseObject(arrayJason, JsonData.class);
        System.out.println(jsonData);
    }

    @Test
    public void test33() {
        A a = new A();
        a.setName("zhangsan");
        a.put("abc", "xxxx");

        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void test44() {
        Map<String, Object> map = new HashMap<>();
        map.put("t", 1.1);
        map.put("t2", new B("xxxxx"));
        String json = JSON.toJSONString(map);
        Object jobj = JSON.parse(json);
        JSONObject jjj = (JSONObject) jobj;

        B b = jjj.getObject("t2", B.class);
        System.out.println(b.getName());
        //JSONObject.parseObject
    }

    @Test
    public void test66() {
        B b = new B("xxxx");
        JSONObject obj = (JSONObject)JSONObject.toJSON(b);
        //System.out.println(obj);
        obj.put("age","10");
        System.out.println(obj);
        B b2 =  obj.toJavaObject(B.class);
        System.out.println(b2.getName());
    }
}

class B {
    private String name;

    public B(String name) {
        this.name = name;
    }

    public B() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class A extends HashMap<String, String> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}