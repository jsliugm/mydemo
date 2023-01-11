package com.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    @Test
    public void test2() {
        List<String> list1 = Lists.newArrayList("ab","cd");
    }

    @Test
    public void test3(){
        List<String> list = Lists.newArrayList("1","1");
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void test4(){
        List<Person> people = Lists.newArrayList(new Person(3L,"003"),new Person(2L,"002"),new Person(1L,"001"));
//        Collections.sort(people, (o1, o2) -> {
//            if(o1.getId()<=o2.getId()) {
//                return -1;
//            }
//            return 0;
//        });
//        System.out.println(people);

        Collections.sort(people, Comparator.comparing(Person::getName));

        System.out.println(people);

    }
}
