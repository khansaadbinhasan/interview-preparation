package codingBlocks.DP;

import java.util.*;

public class PerfectSquares {

    public static void main(String[] args) {
        new PerfectSquares().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(numSquares(n));
    }

    public int numSquares(int n) {
        if( n < 4 ) return n;

        int num = 1;
        int sqr = 1;

        while( sqr <= n ){
            sqr = num * num;
            num++;
        }

        int M = num-2 > 0? num-2:1;
        int N = n+1;

        int[] squares = new int[M];

        for (int i = 0; i < M; i++) {
            squares[i] = (i+1)*(i+1);
        }

        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < N; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if( j < squares[i] ) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-squares[i]] + 1);
            }
        }

        return dp[M-1][N-1];
    }
}