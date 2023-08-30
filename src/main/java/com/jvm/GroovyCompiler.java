package com.jvm;

import groovy.lang.GroovyClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class GroovyCompiler {



    public static void main(String[] args) throws IOException {
        // 编译Groovy脚本并将字节码写入目标路径
        String script = "class Example { def hello() { println 'Hello, World!' } }";
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class<?> clazz = classLoader.parseClass(script);
        String className = clazz.getName();
        String classFileName = className.replace(".", "/") + ".class";
        File classFile = new File(clazz.getProtectionDomain().getCodeSource().getLocation().getFile(), classFileName);
        System.out.println("classFile: " + classFile.getAbsolutePath()); // 调试信息
        byte[] bytecode = Files.readAllBytes(classFile.toPath());
        FileOutputStream out = new FileOutputStream(new File("Example.class"));
        out.write(bytecode);
        out.close();
    }
}
