package CTCI.ch3stacksAndQueues;

import java.util.*;

public class Q6AnimalShelter {

    public static void main(String[] args) {
        new Q6AnimalShelter().demo();
    }

    public void demo(){

        ModifiedQueue catQueue = new ModifiedQueue();
        ModifiedQueue dogQueue = new ModifiedQueue();

        catQueue.enque(1); catQueue.enque(2); catQueue.enque(3);
//        catQueue.enque(1); catQueue.enque(1); catQueue.enque(1);

        System.out.println(catQueue);

    }



}

class ModifiedQueue{

    LinkedList<Integer> queue = new LinkedList<>();

    public void enque(int val){
        if( queue.isEmpty() ) queue.add(val);

        for (int i = 0; i < queue.size() - 1; i++) {
            if( queue.get(i) >= val && queue.get(i+1) <= val ) {
                queue.add(i+1, val);
                return;
            }
        }

        if( queue.getFirst() < val ) queue.addFirst(val);
    }

    public int deque(){
        if( isEmpty() ) return Integer.MIN_VALUE;

        return queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public String toString(){
        return queue.toString();
    }

}



abstract class Animal{
    private int order;
    protected String name;

    public Animal(String n){
        name = n;
    }

    public void setOrder(int ord){
        order = ord;
    }

    public int getOrder(){
        return order;
    }

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
}

class Cat extends Animal{
    public Cat(String n){
        super(n);
    }
}

class AnimalQueue{

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueu(Animal a){
        a.setOrder(order);
        order++;

        if( a instanceof Dog ) dogs.addLast((Dog) a);
        else if(a instanceof Cat) cats.addLast((Cat) a);
    }

    public Animal dequeuAny(){
        if( dogs.size() == 0 ) return dequeuCat();
        else if( cats.size() == 0 ) return dequeDogs();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if( dog.isOlderThan(cat) ) return dequeDogs();
        else return dequeuCat();
    }

    public Dog dequeDogs(){
        return dogs.poll();
    }

    public Cat dequeuCat(){
        return cats.poll();
    }
}

















