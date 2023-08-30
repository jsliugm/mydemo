package com.jvm;

public class JFRTest {
    public static void main(String[] args) {
        while(true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
