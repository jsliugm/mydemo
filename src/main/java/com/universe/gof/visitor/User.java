package com.universe.gof.visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
abstract public class User {
    private String name;
    private String identity;
    private String clazz;

    abstract public void accept(Visitor visitor);
}
