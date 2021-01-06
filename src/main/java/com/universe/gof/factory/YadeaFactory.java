package com.universe.gof.factory;

public class YadeaFactory implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new Yadea();
    }
}
