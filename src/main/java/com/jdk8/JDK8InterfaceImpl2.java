package com.jdk8;

public class JDK8InterfaceImpl2 implements JDK8Interface1,JDK8Interface2 {
        //实现接口后，默认方法名相同，必须复写默认方法
        @Override
        public void defaultMethod() {
            //接口的
            JDK8Interface1.super.defaultMethod();
            System.out.println("实现类复写重名默认方法！！！！");
        }
    }