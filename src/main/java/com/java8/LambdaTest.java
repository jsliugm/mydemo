package com.java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jsliu on 2019/4/28.
 */
public class LambdaTest {
    /**
     * 字符串拼接测试
     */
    @Test
    public void test() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        String ss = list.stream().map(item -> item.toString()).collect(Collectors.joining(" 且 "));
        System.out.println(ss);
    }

    @Test
    public void testFlatMap() {
        Student student = new Student("zhangsan", "1|2|3|4");
        List<Student> studentList = Lists.newArrayList(new Student("zhangsan", "1|2|3|4"), new Student("zhangsan", "1|2|3|5"));
        Map<String, Set<String>> map = studentList.stream().collect(Collectors.toMap(Student::getName, s -> {
            Set<String> set = Sets.newHashSet(s.getAddress().split("\\|"));
            return set;
        }, (o, n) -> {
            o.addAll(n);
            return o;
        }));
        System.out.println(map);
    }

    @Test
    public void testFlatMap2() {
        List<String> list = Lists.newArrayList("3,4,5", "6,2,1,5");
        List<String> result = list.stream().map(item -> item.split(",")).flatMap(Arrays::stream).filter(Predicate.isEqual("abc")).sorted().collect(Collectors.toList());
        result.add("hahah");
        System.out.println(result);
    }

    @Test
    public void intStream() {
        List<String> list = Lists.newArrayList("3,4,5", "6,2,1,5", "3,4,5");
        Map<String,List<Integer>> map = IntStream.range(0, list.size()).boxed().collect(Collectors.toMap(list::get, x -> Lists.newArrayList(x), (o, n) -> {
            o.addAll(n);
            return o;
        }));
        System.out.println(map);
    }

    @Test
    public void test44() {
        System.out.println("Function demo ==========");
        Function<Integer, Integer> func2 = p -> p * 12;
        System.out.println(func2.apply(5));
        System.out.println("BiFunction demo =========");
        System.out.println(operator(1, 2, (a, b) -> a + b));
        System.out.println(operator(1, 2, (a, b) -> a * b));
        BiFunction<Integer, Integer, Integer> bin = (a, b) -> a + b;
        System.out.println(bin.apply(5, 10));
        BiFunction<Integer, Integer, Integer> bin2 = (a, b) -> {
            System.out.println("bin2");
            return a * b;
        };
        System.out.println(bin2.apply(5, 10));
        

        BiFunction<String, String, Student> sbf = Student::new;
        System.out.println(sbf.apply("zhangsan", "zhognguo"));

        System.out.println("Consumer ===================");
        Consumer<String> consumer = obj -> {
            System.out.println(obj);
            System.out.println("consumer called");
        };
        sendMsg("8888", consumer);
        System.out.println("Supplier ==================");
        Supplier<String> supplier = () -> "supplier return";
        System.out.println(supplier.get());
        System.out.println("Predicate===================");
        List<String> list = Lists.newArrayList("aa", "bb", "abc", "ac");
        List<String> a = filter(list, obj -> obj.contains("a"));
        System.out.println(a);
    }

    public static List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> resultList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                resultList.add(s);
            }
        }
        return resultList;
    }

    public static void sendMsg(String phone, Consumer<String> consumer) {
        consumer.accept(phone);
    }

    public static Integer operator(Integer a, Integer b, BiFunction<Integer, Integer, Integer> bf) {
        return bf.apply(a, b);
    }
}


@AllArgsConstructor
@Data
class Student {
    private String name;
    private String address;
}
