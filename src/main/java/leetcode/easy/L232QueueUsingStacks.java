package leetcode.easy;

import java.util.*;


//["MyQueue","push","push","peek","pop","empty"]
//[[],[1],[2],[],[],[]]
public class L232QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public L232QueueUsingStacks() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if( !stack2.isEmpty() ) return stack2.pop();

        while( !stack1.isEmpty() ) stack2.push(stack1.pop());

        return stack2.pop();

    }

    public int peek() {
        if( !stack2.isEmpty() ) return stack2.peek();

        while( !stack1.isEmpty() ) stack2.push(stack1.pop());

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


}
