package com.math;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jsliu on 2019/3/28.
 */
public class BigDecimalTest {
    @Test
    public void test() {
        BigDecimal bigDecimal1 = new BigDecimal(2);
        BigDecimal bigDecimal2 = new BigDecimal(3);
        System.out.println(bigDecimal1.divide(bigDecimal2, 4, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test2() {
        double s = 1.23;
        System.out.println((int) s);
    }

    @Test
    public void test3() {
        BigDecimal b1 = new BigDecimal(999);
        BigDecimal b2 = new BigDecimal(999);
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
    }

    @Test
    public void test4() {
        BigDecimal b = new BigDecimal(1.215);
        b = b.setScale(2, BigDecimal.ROUND_HALF_UP);
        //b.
        System.out.println(b);
    }

    @Test
    public void test5() {
        System.out.println((long) Math.pow(2, 63));
        System.out.println(Long.MAX_VALUE);
    }

    @Test
    public void test6() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        int count = 10000000;

        Set<String> set2 = new HashSet<>();
        set2.add("b");
        set2.add("c");
        StopWatch stopWatch = new StopWatch("校验耗时对比");

        //2
        stopWatch.start("按位运算方式");
        long l = 0 | 2 | 4;
        long l2 = 2;
        for (int i = 0; i < count; i++) {
            long l3 = l & l2;
        }
        stopWatch.stop();


        //set way
        stopWatch.start("set取交集的方式");
        for (int i = 0; i < count; i++) {
            hasIntersection(set, set2);
        }
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }


    private static Boolean hasIntersection(Set<String> setA, Set<String> setB) {
        HashSet<String> resSet = new HashSet<>();
        resSet.addAll(setA);
        resSet.retainAll(setB);
        return !resSet.isEmpty();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");

        Set<String> set2 = new HashSet<>();
        set2.add("d");
        set2.add("a");

        System.out.println(hasIntersection(set, set2));
    }

}
