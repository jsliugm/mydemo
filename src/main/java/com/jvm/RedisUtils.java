package com.jvm;

import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;

public class RedisUtils {
    private static Jedis jedis;

    static {
        jedis = new Jedis("x250", 6379);
        jedis.auth("123");
    }

    public static byte[] get(String name) {
        return jedis.get(name.getBytes(StandardCharsets.UTF_8));
    }

    public static void set(String name, byte[] bytes) {
        jedis.set(name.getBytes(StandardCharsets.UTF_8), bytes);
    }


    public static void main(String[] args) {
        jedis.set("aaa","bbb");
        System.out.println(jedis.get("aaa"));
    }
}
