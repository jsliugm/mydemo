package com.jvm;

public class StringTest {
    private static String A = "hello123111111111111111";
    private static String B = new String ("hello123111111111111111");

    public static void main(String[] args) {
        String a = "hello123111111111111111";
        String b = new String("hello123111111111111111");
        System.out.println(a == A);
        System.out.println(B==A);
    }
}
