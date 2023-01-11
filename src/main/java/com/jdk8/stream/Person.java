package com.jdk8.stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
public class Person {
    Boolean hz;
    String name;
    String address;
    int age;

    public Person(String name, String address, int age) {
        this(false, name, address, age);
    }

    public static void main(String[] args) {
        Person p = new Person(true, "张三", "shanghai", 33);
        Person p1 = new Person("张小三", "shanghai", 5);
        Person p2 = new Person("张大三", "shanghai", 7);
        List<Person> persons = Lists.newArrayList(p, p1, p2);
        //[Person(hz=true, name=张三, address=shanghai, age=33), Person(hz=false, name=张小三, address=shanghai, age=5), Person(hz=false, name=张大三, address=shanghai, age=7)]

        //目标 [Person(hz=true, name=张三|张小三|张大三, address=shanghai, age=33)]
        System.out.println(persons);
    }

}
