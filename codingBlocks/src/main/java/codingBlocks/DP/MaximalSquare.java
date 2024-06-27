package codingBlocks.DP;

import java.util.Scanner;

public class MaximalSquare {

    public static void main(String[] args) {
        new MaximalSquare().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (char) ('0' + sc.nextInt());
            }
        }

        System.out.println(maximalSquare(matrix));
    }

    private int[][] dp;

    public int maximalSquare(char[][] matrix) {

        int maxSideLen = 0;

        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxSideLen = Math.max(maxSideLen, getMaxSquareArr(matrix, i, j));
            }
        }

        return maxSideLen * maxSideLen;
    }

    public int getMaxSquareArr(char[][] matrix, int i, int j){

        if( matrix[i][j] == '0' ) return 0;
        if( i+1 == matrix.length || j+1 == matrix[0].length ||
                matrix[i][j+1] == '0' || matrix[i+1][j+1] == '0' || matrix[i+1][j] == '0' ) return dp[i][j] = 1;

        if( dp[i][j] > 1 ) return dp[i][j];

        return dp[i][j] = 1 + Math.min(     getMaxSquareArr(matrix, i+1, j+1),
                                            Math.min(   getMaxSquareArr(matrix, i, j+1),
                                                        getMaxSquareArr(matrix, i+1, j)
                                                    )
                                        );
    }


}
