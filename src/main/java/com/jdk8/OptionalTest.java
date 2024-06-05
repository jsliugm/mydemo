package com.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test() {
        Student student = new Student(new Address("shanghai","9999"),"zhangsan");
        String city = Optional.ofNullable(student).map(Student::getAddress).map(Address::getCity).orElse(null);
        System.out.println(city);
    }
}

@AllArgsConstructor
@Data
class Student {
    private Address address;
    private String name;
}

@AllArgsConstructor
@Data
class Address {
    private String city;
    private String no;
}