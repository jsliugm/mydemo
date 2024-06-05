package com.exception;

import java.io.Closeable;
import java.io.IOException;

public class TryCatchTest {


    public static void main(String[] args) {
        try (A a = new A()) {

        } catch (Exception e) {

        }
    }
}

class A implements Closeable {
    @Override
    public void close() throws IOException {
        throw new RuntimeException();
    }
}