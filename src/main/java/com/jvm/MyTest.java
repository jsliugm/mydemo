package com.jvm;

/**
 * Created by dell on 2018/1/4.
 */
public class MyTest {
    public static void main(String[] args) {
        Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}
class Singleton{
    private static Singleton singleton = new Singleton();
    public static int counter1;
    public static int counter2=0;
    private Singleton(){
        counter1++;
        counter2++;
    }
    public static Singleton getInstance(){
        return singleton;
    }
}
