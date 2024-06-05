package com.math;

import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        // 创建一个随机数生成器对象
        Random random = new Random();

        // 生成一个1到100之间的随机整数
        int randomNumber = random.nextInt(100) + 1;

        // 打印随机数
        System.out.println("随机数：" + randomNumber);
    }
}
