package designPattern.gof.composite;

import java.util.Iterator;

public abstract class Chassis extends CompositeEquipment{
    public abstract Watt power();
    public abstract Currency netPrice();
    public abstract Currency discountPrice();
}
