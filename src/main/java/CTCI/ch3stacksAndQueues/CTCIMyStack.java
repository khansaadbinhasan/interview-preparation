package CTCI.ch3stacksAndQueues;

import java.util.EmptyStackException;

public class CTCIMyStack<T> {

    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if( top == null ) throw new EmptyStackException();

        T item = top.data;
        top = top.next;

        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek(){
        if( top == null ) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}


