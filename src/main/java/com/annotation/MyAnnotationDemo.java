package com.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by jsliu on 2018/6/26.
 */
@MyConfiguration
public class MyAnnotationDemo {
    public static void main(String[] args) {
        MyAnnotationDemo demo = new MyAnnotationDemo();
        Annotation[] annotations = demo.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}