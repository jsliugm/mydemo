package com.java;

import org.junit.Test;

import java.util.Stack;

public class StackDemo {
    @Test
    public void test(){
        Stack<String> stack = new Stack<>();
        stack.push(null);
        System.out.println(stack.peek());
        System.out.println(null==null);
        System.out.println(null!=null);
    }
}
