package com.ehcache;

/**
 * @program: MyDemo
 * @description: dog
 * @author: guangming.liu
 * @create: 2018-08-15 16:09
 **/
public class Dog {
    private String color;

    public Dog() {
    }

    public Dog(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                '}';
    }
}