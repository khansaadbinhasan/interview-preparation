package CTCI.ch3stacksAndQueues;

import java.util.NoSuchElementException;

public class CTCIMyQueue<T> {

    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item){
        QueueNode<T> t = new QueueNode<T>(item);

        if( last != null ) last.next = t;

        last = t;

        if( first == null ) first = last;
    }

    public T remove(){
        if( first == null ) throw new NoSuchElementException();

        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}