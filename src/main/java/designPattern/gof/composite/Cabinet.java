package designPattern.gof.composite;

public abstract class Cabinet extends CompositeEquipment{
    public Cabinet(String name){

    }
    public abstract Watt power();
    public abstract Currency netPrice();
    public abstract Currency discountPrice();
}
