package com.clazz;

import org.junit.Test;

/**
 * Created by jsliu on 2019/9/26.
 */
public class Main {
    @Test
    public void test() {
        Teacher t = new Teacher();
        Student s = new Student();
        Person p = new Teacher();
        if (p instanceof Teacher) {
            s = (Student) p;
        }
    }
}
