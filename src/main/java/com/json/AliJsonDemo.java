package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.junit.Test;

public class AliJsonDemo {
    @Test
    public void test() {
       /* String json = "{\"name\":\"xxx\",\"age\":null}";
        LinkedHashMap object = JSONObject.parseObject(json,LinkedHashMap.class);
        System.out.println(JSON.toJSONString(object, SerializerFeature.WriteMapNullValue));*/
        String json = "{}";
        Student student = JSONObject.parseObject(json, Student.class);
        System.out.println(student);
    }

    @Test
    public void test2() {
        String stu = "{\"name\":\"zhangsan\"}";

        stu = "{\"name\":\"zhangsan\",\"address1\":null}";

        Student student = JSON.parseObject(stu, Student.class);

        System.out.println(student.getName());
    }
    @Test
    public void test3() {
        String stu = "{\"name\":\"zhangsan\"}";
        // stu = "{\"name\":\"zhangsan\",\"address1\":null}";
        Student student = JSON.parseObject(stu, Student.class);
        //System.out.println(student.getName());
        Object o = JSONObject.toJSON(student);
        System.out.println(o);
    }

}
