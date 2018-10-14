package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by jsliu on 2018/7/23.
 */
public class JsonTest {
    static String arrayJason ;

    @Test
    public void test() {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "zhangsan");
        hashMap.put("age", "10");
        System.out.println(JSONObject.toJSON(hashMap));
    }
    @Before
    public void before(){
        List<String> dataList=new ArrayList<String>();
        for(int i =0 ;i<10;i++){
            dataList.add("testStr"+i);
        }
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("dataList",dataList);
        arrayJason = JSON.toJSON(map).toString();
        System.out.println(arrayJason);
    }
    @Test
    public void test2ArrayToLinkedList(){
        JsonData jsonData = JSONObject.parseObject(arrayJason,JsonData.class);
        System.out.println(jsonData);
    }
}