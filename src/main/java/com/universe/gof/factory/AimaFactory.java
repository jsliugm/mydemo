package com.universe.gof.factory;

public class AimaFactory implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new Aima();
    }
}
