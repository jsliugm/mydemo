package com.string;

public class ConstantB {
    public final static String A = "abcdef";

    public static void main(String[] args) {
        System.out.println(A == ConstantA.A);
        //boolean c = A == ConstantA.A;
        ConstantA.method1("a", 1);
        ConstantA.method2("a", 1, 2f);
        ConstantA.method2_1(1, "a", 2f);
        ConstantA.method3("a", 1, "b");
        ConstantA.method4("a", 1, "b");

        A a = new A();
        a.method1();
        a.method2("cccc");
        a.method3();
        a.method4("dddd");
    }
}
