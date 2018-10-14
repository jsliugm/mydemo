package com.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @program: MyDemo
 * @description: test
 * @author: guangming.liu
 * @create: 2018-09-30 10:08
 **/
public class Jdk8Test {
    @Test
    public void test1() {
        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));
    }

    @Test
    public void test2() {
        List<String> list =
                Arrays.asList("0", "a", "b", "d");
        list.sort((e1, e2) -> e1.compareTo(e2));
        list.forEach(e -> System.out.println(e));
    }
}