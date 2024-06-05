package com.jvm;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by c_liuguangming on 2017/7/21.
 */
public class JvmTest {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        ReferenceQueue<MyObject> softQueue = new ReferenceQueue<MyObject>();
        //SoftReference<MyObject> softRef = new SoftReference<MyObject>(obj, softQueue);
        WeakReference<MyObject> softRef = new WeakReference<>(obj, softQueue);
        new Thread(new CheckRefQueue(softQueue)).start();
        obj = null;
        System.out.println("Before GC:Soft Get= " + softRef.get());
        System.gc();
        System.out.println("After GC:Soft Get= " + softRef.get());
        System.out.println("分配大块内存");
        byte[] b = new byte[16 * 1024 * 1024];
        System.out.println("After new byte[]:Soft Get= " + softRef.get());
    }

    private static class MyObject {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("MyObject's finalize called");
        }

        @Override
        public String toString() {
            return "I am MyObject";
        }
    }

    private static class CheckRefQueue implements Runnable{
        private ReferenceQueue<MyObject> softQueue;

        public CheckRefQueue(ReferenceQueue<MyObject> softQueue) {
            this.softQueue = softQueue;
        }

        @Override
        public void run() {
            System.out.println("===="+Thread.currentThread().getName());
            Reference<MyObject> obj = null;
            try {
                obj = (Reference<MyObject>) softQueue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (obj != null) {
                System.out.println("Object for SoftReference is " + obj.get());
            }
        }
    }
}

