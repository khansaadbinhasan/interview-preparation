package CTCI.ch3stacksAndQueues;

import java.util.Stack;

public class Q5SortStack {

    public static void main(String[] args) {
        new Q5SortStack().run();
    }

    public void run(){

        Stack<Integer> stack = new Stack<>();

//        stack.push(5); stack.push(6); stack.push(4);
//        stack.push(10); stack.push(7);

        stack.push(34); stack.push(3); stack.push(31);
        stack.push(98); stack.push(92); stack.push(23);

//        stack.push(3); stack.push(5); stack.push(1);
//        stack.push(4); stack.push(2); stack.push(8);

        System.out.println(sortStack(stack));
    }

    public Stack<Integer> sortStack(Stack<Integer> stack){

        Stack<Integer> tempStack = new Stack<>();

        if( !stack.isEmpty() ) tempStack.push(stack.pop());

        while( ! stack.isEmpty() ){

            while( !stack.isEmpty() &&
                    !tempStack.isEmpty() &&
                    stack.peek() <= tempStack.peek()) {

                tempStack.push(stack.pop());

            }

            if( !stack.isEmpty() &&
                    !tempStack.isEmpty() &&
                    stack.peek() > tempStack.peek()){

                int temp = stack.pop();

                while( !tempStack.isEmpty() &&
                        tempStack.peek() < temp) {
                    stack.push(tempStack.pop());
                }

                tempStack.push(temp);
            }
        }

        while( !tempStack.isEmpty() ) stack.push(tempStack.pop());

        return stack;
    }

}
