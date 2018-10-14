package com.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @program: MyDemo
 * @description: linkedlist test
 * @author: guangming.liu
 * @create: 2018-08-06 17:36
 **/
public class LinkedListTest {
    static LinkedList<String> list = new LinkedList<String>();

    @Test
    public void test() {
        int i=0;
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
            i++;
            iterator.remove();
        }
        System.out.println(i);
    }

    @Before
    public void before() {
        for (int i = 0; i < 10; i++) {
            list.add("test" + i);
        }
    }

}