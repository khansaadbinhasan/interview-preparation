package PIE.linkedLists;

import java.util.EmptyStackException;


class StackDemo{
    public static void main(String[] args) {
        StackImplementation myStack = new StackImplementation();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack);

        System.out.println(myStack.peek());

        myStack.pop();

        System.out.println(myStack.peek());

        myStack.pop();

        System.out.println(myStack);

        System.out.println(myStack.peek());

        myStack.pop();



        System.out.println(myStack);
        
//        myStack.pop();


    }
}

public class StackImplementation {

    MyLinkedList stack;

    public StackImplementation(){
        this.stack = new MyLinkedList();
    }

    public void push(int val){
        MyNode myNode = new MyNode(val);

        myNode.next = stack.head;
        stack.head = myNode;
    }

    public int pop(){
        if( isEmpty() ) throw new EmptyStackException();

        int val = stack.head.val;

        stack.head = stack.head.next;

        return val;
    }

    public int peek(){
        if( isEmpty() ) throw new EmptyStackException();

        return stack.head.val;
    }

    public boolean isEmpty(){
        return stack.head == null;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}


