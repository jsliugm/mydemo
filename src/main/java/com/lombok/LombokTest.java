package com.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LombokTest {
    private String name;
    private String age;

    public static void main(String[] args) {
        LombokTest lombokTest = new LombokTest("zhangsan","111");
        System.out.println(lombokTest);
    }
}
