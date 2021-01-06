package com.jvm;

import groovy.lang.GroovyClassLoader;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class JolTest {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

        //打印对象占用空间总大小
        GroovyClassLoader classLoader = new GroovyClassLoader();
        System.out.println(ClassLayout.parseInstance(classLoader).toPrintable());
        System.out.println(GraphLayout.parseInstance(classLoader).totalSize());

        GroovyClassLoader classLoader1 = new GroovyClassLoader();
        System.out.println(ClassLayout.parseInstance(classLoader1).toPrintable());
        System.out.println(GraphLayout.parseInstance(classLoader1).totalSize());
    }
}
