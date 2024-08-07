package CTCI.ch3stacksAndQueues;

import java.util.*;

public class Q2MinStack {


    int[] stack = new int[0];
    int[] minStack = new int[0];

    int top = -1;
    int minTop = -1;

    /** initialize your data structure here. */
    public Q2MinStack() {
    }

    public void push(int val) {

        if( stack.length == 0 ) stack = new int[10];
        else if(top == stack.length-1){
            int[] newStack = new int[stack.length];

            System.arraycopy(stack, 0, newStack, 0, stack.length);

            stack = new int[2*stack.length];

            System.arraycopy(newStack, 0, stack, 0, newStack.length);
        }

        stack[++top] = val;

        if( top == 0 || val <= getMin() ) pushMinStack(val);
    }

    public void pushMinStack(int val){
        if( minStack.length == 0 ) minStack = new int[10];
        else if(minTop == minStack.length-1){
            int[] newStack = new int[minStack.length];

            System.arraycopy(minStack, 0, newStack, 0, minStack.length);

            minStack = new int[2*minStack.length];

            System.arraycopy(newStack, 0, minStack, 0, newStack.length);
        }

        minStack[++minTop] = val;
    }

    public void popMinStack() {
        minTop--;
    }

    public void pop() {
        if( top() == getMin() ) popMinStack();

        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[minTop];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public String toString(){
        return Arrays.toString(stack);
    }

    public void demo(){

        Q2MinStack minStack = new Q2MinStack();

        System.out.println("PUSH 2");
        minStack.push(2);
        System.out.println(minStack.toString());

        System.out.println("PUSH 3");
        minStack.push(3);
        System.out.println(minStack.toString());

        System.out.println("PUSH 4");
        minStack.push(4);
        System.out.println(minStack.toString());

        System.out.println("POP");
        minStack.pop();
        System.out.println(minStack.toString());

        System.out.println("PUSH 7");
        minStack.push(7);
        System.out.println(minStack.toString());

        System.out.println("TOP: " + minStack.top());
        System.out.println(minStack.toString());

        System.out.println("POP");
        minStack.pop();
        System.out.println(minStack.toString());

        System.out.println("POP");
        minStack.pop();
        System.out.println(minStack.toString());

        System.out.println("EMPTY: " + minStack.isEmpty());
        System.out.println(minStack.toString());

        System.out.println("TOP: "+  minStack.top());
        System.out.println(minStack.toString());

        System.out.println("POP");
        minStack.pop();
        System.out.println(minStack.toString());

    }

    public static void main(String[] args) {
        new Q2MinStack().demo();
    }

}

