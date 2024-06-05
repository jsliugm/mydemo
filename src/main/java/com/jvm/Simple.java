package com.jvm;

public class Simple {
   //private String name,age;
    public void test(){
        int i = 15;
        int j = 8;
        int k  = i+j;
    }

    public int sum(){
        int i = 15;
        int j = 8;
        int sum = i + j;
        return sum;
    }

    public int callSum(){
        int i = sum();
        return i;
    }

    public void testPlusPlus(){
        int i =10;
        i++;

        int j = 10;
        ++j;

    }
    public void test3() throws Exception{
        Class clazz = Class.forName("com.jvm.Person");
        Object p = clazz.newInstance();
        clazz.getMethod("print").invoke(p);
    }
    public void test4() throws Exception{

        Person p = new Person();
        p.print();
    }
    public static void main(String[] args) {

    }
}
