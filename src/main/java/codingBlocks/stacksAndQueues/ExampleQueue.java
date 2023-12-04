package codingBlocks.stacksAndQueues;

public class ExampleQueue {

    private int[] queue;
    private int size = 0;
    private int enqueuePointer = -1;
    private int dequeuePointer = 0;

    public ExampleQueue(int size){
        this.size = size;
        queue = new int[size];
        enqueuePointer = 0;
    }

//    public boolean isEmpty(){
//        return enqueuePointer == this.size;
//    }

    public void enqueue(int elem){
        if( enqueuePointer == -1 ) throw new RuntimeException("The Queue size has not been initialized");

//        System.out.println(enqueuePointer);
//        System.out.println(this.size);

        if( enqueuePointer == this.size ){
            for (int i = 0; i < size-1; i++) {
                queue[i] = queue[i+1];
            }

            enqueuePointer--;
        }

        queue[enqueuePointer++] = elem;
    }

    public int dequeue(){
        if( enqueuePointer == -1 ) throw new RuntimeException("The Queue size has not been initialized");

        return queue[dequeuePointer++];
    }

    public int front(){
        if( enqueuePointer == -1 ) throw new RuntimeException("The Queue size has not been initialized");


        return queue[dequeuePointer];
    }

    @Override
    public String toString(){
        String qStr = "[";

        for (int i = dequeuePointer; i < enqueuePointer - 1; i++) {
            qStr += this.queue[i] + ",";
        }

        return qStr + this.queue[enqueuePointer-1] + "]";
    }



    public static void main(String[] args) {
        ExampleQueue q = new ExampleQueue(1);

        q.enqueue(1);
        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);

        System.out.println(q.toString());
        System.out.println(q.front());

        q.enqueue(6);
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());

        System.out.println(q.front());
    }

}
