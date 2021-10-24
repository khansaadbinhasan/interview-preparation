package codingBlocks.DP;

import java.util.Stack;

//2,6,4,3,2,2,4,5,7,8,9,6,4,3,3,4,6

public class HistogramArea {

    public static void main(String[] args) {
        new HistogramArea().run();
    }

    public void run(){
        System.out.println(largestRectangleAreaHistogram(new int[]{2,6,4,3,2,2,4,5,7,8,9,6,4,3,3,4,6}));
    }

    public int largestRectangleAreaHistogram(int[] heights) {
        int largestArea = 0;

        Stack<Integer> stackIndices = new Stack<>();

        int index = 0;

        while( index < heights.length ){

            while( stackIndices.isEmpty() || ( index < heights.length && heights[stackIndices.peek()] <= heights[index] ) ){
                stackIndices.push(index);
                index++;
            }

            int topInd = stackIndices.peek();
            int breadth = 0;

            while( !stackIndices.isEmpty() && ((index == heights.length) || heights[stackIndices.peek()] > heights[index]) ){
                int currInd = stackIndices.pop();

                if( !stackIndices.isEmpty() ) breadth = topInd-stackIndices.peek();
                else breadth = index;

                largestArea = Math.max(heights[currInd] * breadth, largestArea);
            }
        }

        return largestArea;
    }

}
