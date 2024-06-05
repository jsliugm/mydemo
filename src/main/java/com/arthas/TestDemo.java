package com.arthas;

public class TestDemo {
// watch com.arthas.TestDemo test
    public static Integer test(){
        return 12222;
    }
    //watch com.arthas.TestDemo test1
    public  Integer test1(){
        return 1345;
    }
    public static void main(String[] args) {

        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
            new TestDemo().test1();
        }


    }
}
