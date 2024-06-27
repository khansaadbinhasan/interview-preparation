package designPattern.gof.composite;

import java.util.Iterator;

public abstract class Equipment {
    private String name;
    public String getName(){
        return name;
    }

    public abstract Watt power();
    public abstract Currency netPrice();
    public abstract Currency discountPrice();
    public abstract void add(Equipment equipment);
    public abstract void remove(Equipment equipment);
    public abstract Iterator<Equipment> createIterator();
}
