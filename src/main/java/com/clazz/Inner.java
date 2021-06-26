package com.clazz;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Inner {
    public static void main(String[] args) {
        log.info("xxx");
        while(true) {
            new Inner(){};
        }
    }
}
