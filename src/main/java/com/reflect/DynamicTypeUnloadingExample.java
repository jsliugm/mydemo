package com.reflect;

import java.lang.reflect.Method;

/** 卸载动态类型示例
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
public class DynamicTypeUnloadingExample {

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
        test2Class();
    }
}
