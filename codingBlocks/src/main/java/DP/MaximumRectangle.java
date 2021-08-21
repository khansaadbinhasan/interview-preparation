package DP;

import java.util.*;

public class MaximumRectangle {

    public static void main(String[] args) {
        new MaximumRectangle().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        char[][] matrix = new char[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (char) ('0' + sc.nextInt());
            }
        }

        System.out.println(maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {

        if( matrix.length == 0 || matrix[0].length == 0 ) return 0;

        int maxArea = 0;

        int[] hist = new int[matrix[0].length];

        Arrays.fill(hist, 0);

        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                hist[j] = row[j] == '1' ? hist[j]+1: 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(hist));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int largestArea = 0;

        Stack<Integer> stackIndices = new Stack<>();

        int index = 0;

        while( index < heights.length ){

            while(stackIndices.isEmpty() || (index < heights.length && heights[stackIndices.peek()] <= heights[index]))
            {
                stackIndices.push(index);
                index++;
            }

            int topInd = stackIndices.peek();
            int breadth = 0;

            while(!stackIndices.isEmpty() && (index == heights.length || heights[stackIndices.peek()] > heights[index]))
            {
                int currInd = stackIndices.pop();

                if( !stackIndices.isEmpty() ) breadth = topInd-stackIndices.peek();
                else breadth = index;

                largestArea = Math.max(heights[currInd] * breadth, largestArea);
            }
        }

        return largestArea;
    }


}
