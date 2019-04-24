package com.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by jsliu on 2019/3/28.
 */
public class BigDecimalTest {
    @Test
    public void test(){
        BigDecimal bigDecimal1 = new BigDecimal(2);
        BigDecimal bigDecimal2 = new BigDecimal(3);
        System.out.println(bigDecimal1.divide(bigDecimal2,4,BigDecimal.ROUND_HALF_UP));
    }
    @Test
    public void test2(){
        double s = 1.23;
        System.out.println((int)s);
    }
    @Test
    public void test3(){
        BigDecimal b1 = new BigDecimal(999);
        BigDecimal b2 = new BigDecimal(999);
        System.out.println(b1==b2);
        System.out.println(b1.equals(b2));
    }
    @Test
    public void test4(){
        BigDecimal b = new BigDecimal(1.215);
        b =  b.setScale(2,BigDecimal.ROUND_HALF_UP);
        //b.
        System.out.println(b);
    }
}
