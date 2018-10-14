package com.redis;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by jsliu on 2018/7/23.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonStoreTest {
    String redisCluster = "docker4bjk:7000,docker4bjk:7001,docker4bjk:7002,docker4bjk:7003,docker4bjk:7004,docker4bjk:7005";
    JedisCluster jedisCluster;

    static String prefix = "luffi:lbl";
    static String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值
    static String nameKey = prefix + KEY_SPLIT + "name";
    static List<Long> timeList = new ArrayList<Long>();

    private static String testStr ;
    @Before
    public void before(){
        String[] serverArray = redisCluster.split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        //注意：这里超时时间不要太短，他会有超时重试机制。而且其他像httpclient、dubbo等RPC框架也要注意这点
        jedisCluster = new JedisCluster(nodes, 1000, 1000, 1, new GenericObjectPoolConfig());

        //大多数测试都是使用【nameKey】测试的，所以在启动之前先把这个key删掉
        jedisCluster.del(nameKey);


        testStr = JSONObject.toJSONString(genMap());
    }

    //@Test
    public void test1Bytes() throws UnsupportedEncodingException {
        byte[] b1 = "test1".getBytes("utf-8");
        byte[] b2 = testStr.getBytes("utf-8");
        timeList.add(System.currentTimeMillis());
        jedisCluster.set(b1,b2);
        timeList.add(System.currentTimeMillis());


    }


   @Test
    public void test2GetBytes() throws UnsupportedEncodingException {
        byte[] b1 = "test1".getBytes("utf-8");
        timeList.add(System.currentTimeMillis());
        //jedisCluster.get(b1);
        String s = new String(jedisCluster.get(b1),"utf-8");
        timeList.add(System.currentTimeMillis());
       System.out.println(s);
    }
   //@Test
    public void test3String(){
        timeList.add(System.currentTimeMillis());
        jedisCluster.set("test1",testStr);
        timeList.add(System.currentTimeMillis());
    }
   //@Test
    public void test4GetString(){
        timeList.add(System.currentTimeMillis());
        jedisCluster.get("test1");
        timeList.add(System.currentTimeMillis());
    }

    Map<String, String> genMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 100000; i++) {
            map.put("key" + i, "value" + i);
        }
        return map;
    }
    @Test
    public void test9PrintCostTime(){
        printCostTime(timeList);
    }

    public void printCostTime(List<Long> timeList){
        int size = timeList.size();
        for(int i=0;i<size/2;i++){
            long cost = timeList.get(i*2+1)-timeList.get(i*2);
            System.out.println(cost);
        }
    }
}