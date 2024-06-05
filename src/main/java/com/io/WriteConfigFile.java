package com.io;

import com.google.common.collect.Maps;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WriteConfigFile {
    public static void main(String[] args) {
        writeConfig();
        readConfig();
    }

    private static void writeConfig() {
        Properties properties = new Properties();

        // 设置配置参数
        properties.setProperty("ke\n=y1", "value1");
        properties.setProperty("key2", "中国人");
        properties.setProperty("key3", "value3");

        for (int i = 0; i < 10; i++) {
            properties.setProperty("key" + i, "value" + i);
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("config.properties"), "utf-8")) {
            // 写入配置文件
            properties.store(writer, "My Configuration");
            System.out.println("配置文件写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readConfig() {
        try (FileInputStream fis = new FileInputStream("config.properties"); InputStreamReader reader = new InputStreamReader(fis, "utf-8"); BufferedReader bw = new BufferedReader(reader)) {
            //读取所有配置
            Properties properties = new Properties();
            properties.load(bw);
            System.out.println(properties.getProperty("key1"));
            System.out.println(properties.getProperty("key2"));

            Map<String, String> map = Maps.newHashMap(Maps.fromProperties(properties));
            System.out.println(map);

            System.out.println(Maps.newLinkedHashMap(Maps.fromProperties(properties)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}