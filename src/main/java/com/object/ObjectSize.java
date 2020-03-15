package com.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

@Slf4j
public class ObjectSize {
    public static void main(String[] args) {
        String test = "1";
        //计算指定对象及其引用树上的所有对象的综合大小，单位字节
        long size = RamUsageEstimator.sizeOf(test);
        log.info("sizeof = {}", size);
        //计算指定对象本身在堆空间的大小，单位字节
        long shallowSize = RamUsageEstimator.shallowSizeOf(test);
        log.info("shallowSize = {}", shallowSize);
         //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
        String humanSizeOf = RamUsageEstimator.humanSizeOf(test);
        log.info("humanSize = {}", humanSizeOf);
    }
    private void printSize(Object obj){
        //计算指定对象及其引用树上的所有对象的综合大小，单位字节
        long size = RamUsageEstimator.sizeOf(obj);
        log.info("sizeof = {}", size);
        //计算指定对象本身在堆空间的大小，单位字节
        long shallowSize = RamUsageEstimator.shallowSizeOf(obj);
        log.info("shallowSize = {}", shallowSize);
        //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
        String humanSizeOf = RamUsageEstimator.humanSizeOf(obj);
        log.info("humanSize = {}", humanSizeOf);
    }
    @Test
    public void test(){
        Person p = new Person("1","2");
        printSize(p);

        Person2 p2 = new Person2("1");
        printSize(p2);
    }
    @Data
    @AllArgsConstructor
     class Person{
        private String name;
        private String address;
    }
    @Data
    @AllArgsConstructor
    class Person2{
        private String name;
    }
}
