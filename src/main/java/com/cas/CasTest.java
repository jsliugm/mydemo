package com.cas;

import sun.misc.Unsafe;

public class CasTest {
    public static void main(String[] args) {
        MyCas myCas = new MyCas();
        myCas.cas(1,2);
       // System.out.println(myCas);
        System.out.println(MyCas.getCount());
    }
}
class MyCas{
    private final static long count=1L;
    private final static Unsafe unsafe = Unsafe.getUnsafe();
    boolean cas(long expect,long update){
        return unsafe.compareAndSwapLong(this,count,expect,update);
    }
    public static long getCount() {
        return count;
    }
}
