package com.jvm;

import groovy.lang.Binding;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.runtime.InvokerHelper;

@Slf4j
public class RedisClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        log.info("findClass {}", name);
        //byte[] classBytes = classes.get(name);G
        String className = name + ".class";
        byte[] classBytes = RedisUtils.get(className);
        if (classBytes == null) {
            return super.findClass(name);
        }
        Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        RedisClassLoader redisClassLoader = new RedisClassLoader();
        Class<?> clazz = redisClassLoader.loadClass("Example");
        InvokerHelper.createScript(clazz, new Binding()).run();
        redisClassLoader.loadClass("Example");
        InvokerHelper.createScript(clazz, new Binding()).run();
    }
}
