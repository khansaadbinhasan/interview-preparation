package designPattern;

import java.util.ArrayList;

public class ObserverPatternII {
    public interface Subject {
        public void registerObserver(Observer observer);
        public void unregisterObserver(Observer observer);
        public void notifyObservers();
    }

    public class Channel implements Subject {
        private ArrayList<Observer> observers = new ArrayList<>();
        private String channelName;
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void registerObserver(Observer observer){
            observers.add(observer);
        }

        public void unregisterObserver(Observer observer){
            observers.remove(observer);
        }

        public void notifyObservers(){
            for( Observer o: observers ){
                o.update(this.channelName + " is " + getStatus());
            }
        }
    }

    public interface Observer {
        public void update(String status);
    }

    public class Follower implements Observer {
        private String followerName;

        public void update(String status){
            System.out.println(status);
        }

        public void play(){
            System.out.println("Playing");
        }
    }


}
