package com.jvm;

public class InvokeTest {
    Person person = new Person();

    public void test() throws Exception {
//        Person p = new Person();
//        p.print();
           Class clz = Class.forName("com.jvm.Person");
        // Object obj = clz.newInstance();
        clz.getMethod("print").invoke(person);

    }

    public static void main(String[] args) {
    }
}
