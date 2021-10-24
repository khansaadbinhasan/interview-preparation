package PIE.problems;

import java.util.LinkedList;

public class ProducerConsumerThreads {

    public static void main(String[] args) throws InterruptedException{

        //Objects of a class that has both produce() and consume()
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    //This class has a list, producer (adds items to list)
    //and consumer (removes items)
    public static class PC{

        //Create a list shared by producer and consumer
        //Size of list is 2
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        //Function called by producer thread
        public void produce() throws InterruptedException{

            int value = 0;

            while (true){

                synchronized (this){

                    //producer thread waits while list is full
                    while( list.size() == capacity ) wait();

                    System.out.println("Producer produced- " + value);

                    //insert jobs in list
                    list.add(value++);

                    //notifies consumer thread that it can start consuming
                    notify();

                    Thread.sleep(1000);
                }
            }
        }

        // Function called by consumer thread
        public void consume() throws InterruptedException{

            while( true ){
                synchronized (this){

                    //consumer thread wait while list is empty
                    while (list.size() == 0) wait();

                    //to retrieve first job in the list
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed- " + val);

                    //wake up producer thread
                    notify();

                    Thread.sleep(1000);
                }
            }

        }
    }


}
