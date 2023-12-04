package leetcode.easy;

import java.util.*;

//["MyStack","push","push","top","pop","empty"]
//[[],[1],[2],[],[],[]]
//["MyStack","push","push","pop","top"]
//[[],[1],[2],[],[]]
public class L225StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public L225StackUsingQueues() {

    }

    public boolean empty(){
        return q1.isEmpty() && q2.isEmpty();
    }

    public void push(int x){
        q1.offer(x);
    }

    public int pop(){
        int prevElem = -1;

        while( !q1.isEmpty() ) {
            prevElem = q1.poll();
            q2.offer(prevElem);
        }

        while( q2.size() != 1 ) {
            q1.offer(q2.poll());
        }

        return q2.poll();
    }

    public int top(){
        int prevElem = -1;

        while( !q1.isEmpty() ) {
            prevElem = q1.poll();
            q2.offer(prevElem);
        }

        while( !q2.isEmpty() ) {
            q1.offer(q2.poll());
        }

        return prevElem;
    }


}
