package com.map;

public abstract class ManagedObject {
    protected IdObject value;

    public ManagedObject(IdObject value) {
        this.value = value;
    }

    public IdObject getValue() {
        return value;
    }

    abstract void remove();
}
