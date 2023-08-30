package com.java;

public class WhileTest {


    volatile int i;


    public static void main(String[] args) throws InterruptedException {

        WhileTest whileTest = new WhileTest();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            whileTest.i++;
                        }
                    }
                }
        ).start();


        while (true) {
            if (whileTest.i > 100) {
                break;
            }
            Thread.sleep(100L);
        }


        System.out.println("over ~~~~");


    }
}
