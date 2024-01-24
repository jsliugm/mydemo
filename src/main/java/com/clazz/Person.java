package com.clazz;

import lombok.Data;

@Data
public class Person {
    private String name;
    public void test() {

        int a = 0;
        for (int i = 0; i < 100; i++) {
            a = 0;
            int b = 0;
            System.out.println(a + i);
        }
    }

    public static void main(String[] args) {

    }
}
