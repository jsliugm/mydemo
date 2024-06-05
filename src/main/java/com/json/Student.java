package com.json;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String name;
    private List<String> address;
}
