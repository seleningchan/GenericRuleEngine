package org.conley.api;

import java.util.Objects;

public class Fact<T> {
    private final String name;
    private final T value;

    public Fact(String name, T value){
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(value, "value must not be null");
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Fact{"+
                "name='"+name+'\''+
                ",value="+value+
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null||getClass()!=obj.getClass())
            return false;
        Fact<?> fact = (Fact<?>) obj;
        return name.equals(fact.name);
    }
}
