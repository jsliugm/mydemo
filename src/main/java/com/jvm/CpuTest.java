package com.jvm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.io.FileUtil;
import com.redis.ObjectUtils;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jsliu on 2019/10/18.
 */
public class CpuTest {
    @Test
    /**
     * 往列表添加数据
     */
    public void test1() {
        StopWatch stopWatch = new StopWatch("add element to list");
        int count = 10000000;
        List list = Lists.newArrayListWithExpectedSize(count);
        stopWatch.start("start");
        String tt = "0";
        String tt2 = "8888888888";
        for (int i = 0; i < count; i++) {
            list.add(i + tt2);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    /**
     * 加法运算
     */
    public void test2() {
        int count = 100000000;
        int j = 0;
        for (int i = 0; i < count; i++) {
            j = i + i;
        }
        System.out.println(j);
    }

    /**
     * 序列化测试
     */
    @Test
    public void test3() {
        StopWatch stopWatch = new StopWatch("序列化测试");
        int count = 10000000;
        List<String> list = Lists.newArrayListWithExpectedSize(count);
        stopWatch.start("add element to list");
        for (int i = 0; i < count; i++) {
            list.add(i + "");
        }
        stopWatch.stop();
        stopWatch.start("序列化");
        System.out.println("开始序列化");
        //序列化
        byte[] bytes = ObjectUtils.objectToByteArray(list);
        stopWatch.stop();
        stopWatch.start("保存");
        System.out.println("保存至xxx");
        FileUtil.bytes2File(bytes, "e:\\oo.txt");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 反序列化测试
     */
    @Test
    public void test4() {
        List<String> list = FileUtil.file2Object("e:\\oo.txt");
        System.out.println(list.size());
    }

    @Test
    public void test5() {
        int count = 10000000;
        Map<String,String> map = Maps.newHashMapWithExpectedSize(count);
       // Map<String, String> map = new HashMap<>();
        StopWatch stopWatch = new StopWatch("map put");
        stopWatch.start();
        for (int i = 0; i < count; i++) {
            map.put("" + i, "" + i);
        }
        stopWatch.stop();
        stopWatch.start("get test");
        map.get("1111");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    @Test
    public void test6(){
        while(true) {
            FileUtil.File2String("e:\\oo.txt");
        }
    }
}
