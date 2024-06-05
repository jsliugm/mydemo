package com.jvm;

public class A {
    public void print(){
        int i =0;
        i++;
        System.out.println(i);
        if(i>1) {
            System.out.println("ok");
        }
    }
    public static void main(String[] args) {
        A a = new A();
    }
}
