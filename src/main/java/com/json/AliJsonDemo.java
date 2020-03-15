package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AliJsonDemo {
    @Test
    public void test() {
       /* String json = "{\"name\":\"xxx\",\"age\":null}";
        LinkedHashMap object = JSONObject.parseObject(json,LinkedHashMap.class);
        System.out.println(JSON.toJSONString(object, SerializerFeature.WriteMapNullValue));*/
       String json = "{}";
       Student student = JSONObject.parseObject(json,Student.class);
        System.out.println(student);
    }
}
