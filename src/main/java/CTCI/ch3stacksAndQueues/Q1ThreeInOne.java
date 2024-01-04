package CTCI.ch3stacksAndQueues;

import java.util.EmptyStackException;

public class Q1ThreeInOne {

    public static void main(String[] args) {
        new Q1ThreeInOne().run();
    }

    public void run(){

    }

}

class MultiStack{

    private StackInfo[] info;
    private int[] values;

    private class StackInfo{
        public int start, size, capacity;

        public StackInfo(int start, int capacity){
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int index){
            if( index < 0 || index >=   values.length ) return false;

            int contiguousIndex = index < start ? index + values.length: index;
            int end = start + capacity;

            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex(){
            return adjustIndex(start+capacity-1);
        }

        public int lastElementIndex(){
            return adjustIndex(start + capacity - 1);
        }

        public boolean isFull(){
            return size == capacity;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }

    public MultiStack(int numberOfStacks, int defaultSize){
        info = new StackInfo[numberOfStacks];

        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }

        values = new int[numberOfStacks * defaultSize];
    }

    public void push(int stackNum, int value) throws FullStackException{

        if( allStacksAreFull() ) throw new FullStackException();

        StackInfo stack = info[stackNum];

        if( stack.isFull() ) expand(stackNum);

        stack.size++;

        values[stack.lastCapacityIndex()] = value;
    }

    public int pop(int stackNum) throws Exception{
        StackInfo stack = info[stackNum];

        if( stack.isEmpty() ) throw new EmptyStackException();

        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0;
        stack.size--;

        return value;
    }

    public int peek(int stackNum){
        StackInfo stack = info[stackNum];
        return values[stack.lastElementIndex()];
    }

    private void shift(int stackNum){
        System.out.println("///Shifting " + stackNum);

        StackInfo stack = info[stackNum];

        if( stack.size >= stack.capacity ){
            int nextStack = (stackNum+1) % info.length;
            shift(nextStack);
            stack.capacity++;
        }

        int index = stack.lastCapacityIndex();

        while( stack.isWithinStackCapacity(index) ){
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);

            values[stack.start] = 0;
            stack.start = nextIndex(stack.start);
            stack.capacity--;
        }
    }

    private void expand(int stackNum){
        shift((stackNum+1) % info.length);
        info[stackNum].capacity++;
    }

    public int numberOfElements(){
        int size = 0;

        for( StackInfo sd: info ){
            size += sd.size;
        }

        return size;
    }

    public boolean allStacksAreFull(){
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index){
        int max = values.length;

        return ((index % max) + max) % max;
    }

    private int nextIndex(int index){
        return adjustIndex(index+1);
    }

    private int previousIndex(int index){
        return adjustIndex(index-1);
    }
}




class FixedMultiStack{

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSizes){
        stackCapacity = stackSizes;
        values = new int[stackSizes*numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException{
        if( isFull(stackNum) ){
            throw new FullStackException();
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum){
        if( isEmpty(stackNum) ) throw new EmptyStackException();

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;

        return value;
    }

    public int peek(int stackNum){
        if( isEmpty(stackNum) ) throw new EmptyStackException();

        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];

        return offset + size - 1;
    }

}

class FullStackException extends Exception{

    private static final long serialVersionUID = 1L;

    public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}

