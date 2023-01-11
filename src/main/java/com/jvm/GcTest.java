package com.jvm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GcTest {
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
               -XX:SurvivorRatio
            */
    public static void main(String[] args) {
        printUsedMemory();
        byte[] a1 = new byte[7 * 1024 * 1024];
        printUsedMemory();
        //makeGarbage(32);
        byte[] a2 = new byte[41 * 1024 * 1024];
        printUsedMemory();
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

    public static void makeGarbage(int size) {
        byte[] a = new byte[size * 1024 * 1024];
    }


    public static void printUsedMemory() {
        Runtime r = Runtime.getRuntime();
        log.info("----memory info----free: {}M max: {}M total: {}M ", r.freeMemory() / (1024 * 1024), r.maxMemory() / (1024 * 1024), r.totalMemory() / (1024 * 1024));
    }
}