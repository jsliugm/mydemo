package com.beancopy;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @program: MyDemo
 * @description: 测试
 * @author: guangming.liu
 * @create: 2018-08-29 18:31
 **/
public class BeanCopyTest {
    /**
     * 测试目的：属性个数不匹配
     */
    @Test
    public void test1(){
        A a = new A();
        B b = new B("a","b");
        BeanUtils.copyProperties(b,a);
        System.out.println(a);

   }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B("a","b");
        BeanUtils.copyProperties(b,a);
        System.out.println(a);
        Thread.sleep(1000000L);
    }
}
class A{
    private String a;

    public A() {
    }

    public A(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                '}';
    }
}
class B{
    private String a;
    private String b;

    public B() {
    }

    public B(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "B{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}