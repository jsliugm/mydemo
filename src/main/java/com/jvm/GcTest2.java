package com.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GcTest2 {
    //java -XX:+PrintCommandLineFlags -version
//-XX:+PrintFlagsFinal 打印所有参数
    /* vm参数：
               -verbose:gc
               -Xmx200M
               -Xms200M
               -Xmn50M
               -XX:+PrintGCDetails
               -XX:TargetSurvivorRatio=60
               -XX:+PrintTenuringDistribution
               -XX:+PrintGCDateStamps
               -XX:MaxTenuringThreshold=6
               -XX:+UseConcMarkSweepGC
               -XX:+UseParNewGC
               -XX:+PrintGCApplicationStoppedTime
               -XX:+PrintGCApplicationConcurrentTime
               -XX:+PrintHeapAtGC

            */
    private static List<byte[]> list = new ArrayList<>();
    private static long l = 0;
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(10);
//        printUsedMemory();
            byte[] a1 = new byte[1 * 1024 * 1024];
//        printUsedMemory();
            //makeGarbage(32);
           // byte[] a2 = new byte[7 * 1024 * 1024];
            list.add(a1);
            //list.add(a2);
            if(l%100==0) {
                System.out.println("clear =================");
                list.clear();
            }
            l++;
//        printUsedMemory();
            // byte[] a3 = new byte[41 * 1024 * 1024];
            //  byte[] a1 = new byte[1 * 1024 * 1024];
//        byte[] a1 = new byte[1 * 1024 * 1024];
//        byte[] a2 = new byte[1 * 1024 * 1024];
//        byte[] a3 = new byte[2 * 1024 * 1024];
//
//        makeGarbage(32);
//        //
//        byte[] a4 = new byte[1 * 1024 * 1024];
//
//        //占满eden
//        makeGarbage(38);
//        byte[] a5 = new byte[1 * 1024 * 1024];
        }
    }

    public static void makeGarbage(int size) {
        byte[] a = new byte[size * 1024 * 1024];
    }


    public static void printUsedMemory() {
        Runtime r = Runtime.getRuntime();
        log.info("----memory info----free: {}M max: {}M total: {}M ", r.freeMemory() / (1024 * 1024), r.maxMemory() / (1024 * 1024), r.totalMemory() / (1024 * 1024));
    }
}