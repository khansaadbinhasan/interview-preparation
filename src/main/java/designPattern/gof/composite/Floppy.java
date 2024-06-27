package designPattern.gof.composite;

import java.util.Iterator;

public class Floppy extends Equipment{

    @Override
    public Watt power() {
        return null;
    }

    @Override
    public Currency netPrice() {
        return null;
    }

    @Override
    public Currency discountPrice() {
        return null;
    }

    @Override
    public void add(Equipment equipment) {

    }

    @Override
    public void remove(Equipment equipment) {

    }

    @Override
    public Iterator<Equipment> createIterator() {
        return null;
    }
}
