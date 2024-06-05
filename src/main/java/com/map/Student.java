package com.map;

public class Student implements IdObject {
    private String id;

    private String name;

    public Student(String id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public Object getId() {
        return id;
    }
}
