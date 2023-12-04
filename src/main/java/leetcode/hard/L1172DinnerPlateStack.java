package leetcode.hard;


import java.util.*;

//["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
//[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
//["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
//[[2],[1],[2],[3],[4],[7],[8],[20],[21],[0],[2],[],[],[],[],[]]
public class L1172DinnerPlateStack {

    List<Stack<Integer>> lstStack = new ArrayList<>();
    int capacity = 0;
    int indCurrNotFilledStack = 0;

    public L1172DinnerPlateStack(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        for( int i = 0; i < lstStack.size(); i++ ){
            if( !isStackFilled(lstStack.get(i)) ) {
                lstStack.get(i).push(val);
                return;
            }
        }

        Stack<Integer> newStack = new Stack<>();

        newStack.push(val);

        lstStack.add(newStack);
    }

    public int pop() {
        for( int i = lstStack.size()-1; i >= 0; i-- ){
            if( !lstStack.get(i).isEmpty() ) return lstStack.get(i).pop();
        }

        return -1;
    }

    public int popAtStack(int index) {

        if( index >= lstStack.size() ) return -1;

        Stack<Integer> tempStack = lstStack.get(index);

        return tempStack.isEmpty()? -1: tempStack.pop();
    }

    public boolean isStackFilled(Stack<Integer> stack){
        return stack.size() == this.capacity;
    }


}
