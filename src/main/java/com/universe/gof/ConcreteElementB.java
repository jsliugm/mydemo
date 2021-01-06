package com.universe.gof;

public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
    }
    public void operationB(){
        System.out.println("operationB");
    }
}
