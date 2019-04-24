package com.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) list.add("tom" + i);
        System.out.println(list);
        //
        list.add(4, "tom88");
        System.out.println(list);
        list.remove("tom88");
        System.out.println(list);
        for (String str : list) {
            list.remove(str);
            System.out.println(list);
        }
    }

    @Test
    public void test() {
        List<String> list1 = Lists.newArrayList("ab","cd");
        List<String> list2 = Lists.newArrayList("ef","gh");
        List<List> list3 = Lists.newArrayList(list1,list2);
        System.out.println(list3);
        list3.stream().flatMap(ss -> ss.stream()).forEach(s-> System.out.println(s));
    }

}
