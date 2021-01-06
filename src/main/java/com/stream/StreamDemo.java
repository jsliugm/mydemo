package com.stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.List;

public class StreamDemo {
    @Test
    public void list2Map() {

        List<Student> studentList = Lists.newArrayList(new Student("a", "zhangsan", "address1"),
                new Student("a", "zhangsan1", "address1"),
                new Student("a", "zhangsan2", "address1"),
                new Student("a", "zhangsan3", "address1"));

    }

    public static void main(String[] args) {
    }
}

@Data
@AllArgsConstructor
class Student {
    private String clazz;
    private String name;
    private String address;
}