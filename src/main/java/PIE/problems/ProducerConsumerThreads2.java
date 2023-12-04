package PIE.problems;

import java.util.Random;

public class ProducerConsumerThreads2 {




}


class Producer extends Thread{

    private static final int MAX_CAPACITY = 8;
    private static final int RANDOM_RANGE = 128;

    private int[] buffer;
    private int index;
    private Random generator;

    public Producer(){
        buffer = new int[MAX_CAPACITY];
        generator = new Random(23);
        index = 0;
    }

    public void run(){
        while( true ){

            try {
                putInt();
            }

            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private synchronized void putInt() throws InterruptedException{
        while( index == MAX_CAPACITY ) wait();

        buffer[index++] = generator.nextInt(RANDOM_RANGE);
        notifyAll();
    }

    public synchronized int getInt() throws InterruptedException{

        notifyAll();

        while (index <= 0) wait();

        index--;

        return buffer[index];

    }
}

class Consumer extends Thread{

    private Producer producer;

    public Consumer(Producer theProducer){
        producer = theProducer;
    }

    public void run(){
        try {
            while (true){
                System.out.println("Int is " + producer.getInt());
            }
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        new Consumer(producer).start();
    }

}