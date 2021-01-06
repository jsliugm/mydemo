package com.universe.gof.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operation();
    }
}

interface Implementor {
    void operationImpl();
}

class ConcreteImplementorA implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA");
    }
}

class ConcreteImplementorB implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorB");
    }
}

abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction {

    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("RefinedAbstraction");
        implementor.operationImpl();
    }
}