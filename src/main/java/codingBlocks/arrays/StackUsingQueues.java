package codingBlocks.arrays;

import java.util.Arrays;

public class StackUsingQueues {

    int[] stack = new int[0];

    public boolean isEmpty(){
        return stack.length == 0;
    }

    public void push(int x){
        int[] newStack = Arrays.copyOf(this.stack, this.stack.length);

        this.stack = new int[this.stack.length+1];
        System.arraycopy(newStack, 0, this.stack, 0, this.stack.length-1);
        this.stack[this.stack.length-1] = x;
    }

    public int pop(){

        if( isEmpty() ) throw new NullPointerException();

        int poppedElem = this.stack[this.stack.length-1];

        int[] newStack = this.stack;
        this.stack = new int[this.stack.length-1];

        System.arraycopy(newStack, 0, this.stack, 0, this.stack.length);

        return poppedElem;
    }

    public int top(){
        return this.stack[this.stack.length-1];
    }


    class MyStack{

        private int[] array;
        private int top;
        private int capacity;


        public MyStack(int capacity){
            this.array = new int[capacity];
            this.capacity = capacity;
            this.top = -1;
        }

        public void push(int item){

            if( isFull() ) throw new RuntimeException("Stack is Full");

            array[top++] = item;
        }

        public int pop(int item){

            if( isEmpty() ) throw new RuntimeException("Stack is Empty");

            return array[top--];
        }

        public int peek(){

            if( isEmpty() ) throw new RuntimeException("Stack is Empty");

            return array[top];
        }

        public boolean isEmpty(){
            return top == -1;
        }

        public boolean isFull(){
            return top == capacity;
        }
    }

}
