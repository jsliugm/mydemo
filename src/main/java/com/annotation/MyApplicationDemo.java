package com.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by jsliu on 2018/6/26.
 */
@MyApplication
public class MyApplicationDemo {
    public static void main(String[] args) {
        Annotation[] annotations =
                MyApplicationDemo.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            System.out.println(annotation.annotationType());
        }
    }
}