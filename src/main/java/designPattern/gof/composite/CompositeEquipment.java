package designPattern.gof.composite;

import java.util.Iterator;

public class CompositeEquipment extends Equipment {
    @Override
    public Watt power() {
        return null;
    }

    @Override
    public Currency netPrice() {
        Iterator<Equipment> i = createIterator();
        Currency total = new Currency(0);

        while( i.hasNext() ){
            total = new Currency(total.val+i.next().netPrice().val);
        }

        return total;
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
