package com.reflect;

import java.lang.reflect.Method;
import java.util.Random;

/*
-Xms20m
-Xmx20m
-XX:+PrintFlagsFinal
-XX:+PrintGCDetails
-XX:+PrintTenuringDistribution
-XX:+PrintGCDateStamps
-XX:+PrintHeapAtGC
-XX:MetaspaceSize=100m
-XX:MaxMetaspaceSize=100m
-XX:SoftRefLRUPolicyMSPerMB=0
-Xloggc:/applog/gc.log
-verbose:class
-XX:+UnlockDiagnosticVMOptions
-XX:-DisplayVMOutput
-XX:+LogVMOutput
-XX:LogFile=/applog/safepoint.log
 */
/* 卸载动态类型示例
-Xms20m
        -Xmx20m
        -XX:+PrintFlagsFinal
        -XX:+PrintGCDetails
        -XX:+PrintTenuringDistribution
        -XX:+PrintGCDateStamps
        -XX:+PrintHeapAtGC
        -XX:MetaspaceSize=1000m
        -XX:MaxMetaspaceSize=1000m
        -Xloggc:/applog/gc.log
        -verbose:class
-XX:+UnlockDiagnosticVMOptions
        -XX:-DisplayVMOutput
        -XX:+LogVMOutput
        -XX:LogFile=/applog/safepoint.log

 */
public class ReflectDemo {
    public static void test1w() throws Exception {
        Student student = new Student();
        student.setName("zhangsan");
        // byte[] bytes;
        // 创建一个随机数生成器对象
        Random random = new Random();
        for (int j = 0; j < 1000; j++) {
            for (int i = 1; i <= 10000; i++) {
                // 生成一个1到100之间的随机整数
//                int randomNumber = random.nextInt(100) + 1;
//                if (randomNumber > 90) {
//                    byte[] bytes = new byte[1024 * 2 * 1024];
//                }
                Method method = Student.class.getMethod("getName" + i, null);
                method.invoke(student, null);
            }
        }
    }

    public static void test2Class() throws Exception {
        Student student = new Student();
        student.setName("zhangsan");

        Student2 student2 = new Student2();
        student2.setName("zhangsan");

        Class clazz;
        Object obj;
        for (int j = 0; j < 1000; j++) {
            if (j % 4 == 0) {
                clazz = Student.class;
                obj = student;

            } else {
                clazz = Student2.class;
                obj = student2;
            }
            for (int i = 1; i <= 10000; i++) {
                Method method = clazz.getMethod("getName" + i, null);
                method.invoke(obj, null);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //test1w();
        test2Class();
//        Student student = new Student();
//        student.setName("zhangsan");
//
//        for (int i = 0; i < 10000; i++) {
//            Method method = Student.class.getMethod("getName", null);
//            System.out.println(method.hashCode());
////            if(i>=15) {
////                System.out.println("");
////            }
//            System.out.println(method.invoke(student, null));
//            System.gc();
    }
}
