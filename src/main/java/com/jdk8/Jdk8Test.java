package com.jdk8;

import com.clazz.Person;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void test3() throws Exception {

        Person person = new Person();
        Method method = Person.class.getMethod("test",null);
        method.invoke(person,null);
    }
}