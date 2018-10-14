package com.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 测试redis存取速度
 * Created by jsliu on 2018/7/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisDemo {
    String redisCluster = "docker4dev:7000,docker4dev:7001,docker4dev:7002,docker4dev:7003,docker4dev:7004,docker4dev:7005";
    JedisCluster jedisCluster;

    static String prefix = "luffi:lbl";
    static String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值
    String nameKey = prefix + KEY_SPLIT + "name";
    static List<Long> timeList = new ArrayList<Long>();
    static Map<String,String> data;
    @Before
    public void connection() {
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

        data = genMap();
    }

    //@Test
    public void test0() {

        jedisCluster.del(nameKey);

    }

    @Test
    public void test3Hmset() {

        timeList.add(System.currentTimeMillis());
        jedisCluster.hmset("testHash", data);
        //jedisCluster.expire("testHash",20);
        timeList.add(System.currentTimeMillis());
        ///jedisCluster.set
    }

    @Test
    public void test4HGet() {
        timeList.add(System.currentTimeMillis());
        Map<String, String> map = jedisCluster.hgetAll("testHash");
        timeList.add(System.currentTimeMillis());
        //System.out.println(map);
    }

    Map<String, String> genMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 1000; i++) {
            map.put("key" + i, "value" + i);
        }
        return map;
    }

    @Test
    public void test1SetByte() throws UnsupportedEncodingException {
        timeList.add(System.currentTimeMillis());
        String key = "testByte";
        byte[] bytes = ObjectUtils.objectToByteArray(data);
        jedisCluster.set(key.getBytes("utf-8"), bytes);
        //jedisCluster.expire("testByte",20);
        timeList.add(System.currentTimeMillis());
    }

    @Test
    public void test2GetByte() throws UnsupportedEncodingException {
        timeList.add(System.currentTimeMillis());
        String key = "testByte";
        byte[] bytes = jedisCluster.get(key.getBytes("utf-8"));
        Map<String, String> map = ObjectUtils.byteArrayToObject(bytes);
        timeList.add(System.currentTimeMillis());
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