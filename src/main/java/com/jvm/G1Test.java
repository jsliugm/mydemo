package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class G1Test {
    private static byte[] getByte() {
        return new byte[1024 * 1024 * 100];
    }

    /**
     * 对比G1和默认GC耗时
     * <div>
     * -verbose:gc
     * -Xmx10g
     * -Xms10g
     * -XX:+PrintGCDetails
     * -XX:+PrintTenuringDistribution
     * -XX:+PrintGCDateStamps
     * -XX:+PrintHeapAtGC
     * -XX:+UseG1GC
     * -XX:+PrintGCApplicationStoppedTime
     * </div>
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        //运行间隔
        long inv = 1000 * 20;
        //如何出发老年代回收
        List<byte[]> list = new ArrayList<>();
        while (System.currentTimeMillis() - begin <= inv) {
            list.add(getByte());
            if (list.size() == 5) {
                list.clear();
            }
        }
    }
}
