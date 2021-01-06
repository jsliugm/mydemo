package com.universe.common;

import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class YamlUtils {
    private static Map<String,String> conf;
    static{
        ClassPathResource classPathResource = new ClassPathResource("/gof/factory.yaml");
        try {
             conf = new Yaml().load(classPathResource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            conf = Collections.emptyMap();
        }
    }
    public static String getValue(String name){
        return conf.get(name);
    }
}