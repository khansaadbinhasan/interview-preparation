package designPattern;

import java.util.ArrayList;

public class ObserverPattern {

    public class Subject{
        private ArrayList<Observer> observers = new ArrayList<Observer>();

        public void registerObserver(Observer observer){
            observers.add(observer);
        }

        public void unregisterObserver(Observer observer){
            observers.remove(observer);
        }

        public void notifyObserver(){
            for( Observer o: observers ){
                o.update();
            }
        }
    }

    public class Blog extends Subject{
        private String state;

        public String getState(){
            return state;
        }
    }

    public interface Observer{
        public void update();
    }

    public class Subscriber implements Observer{
        public void update(){
            System.out.println("updated");
        }
    }



}
