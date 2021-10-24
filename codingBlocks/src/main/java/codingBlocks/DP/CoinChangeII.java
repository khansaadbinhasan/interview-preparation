package codingBlocks.DP;

import java.util.*;

public class CoinChangeII {

    public static void main(String[] args) {
        new CoinChangeII().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        int M = sc.nextInt();

        int[] coins = new int[M];

        for (int i = 0; i < M; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(change(amount, coins));
    }

    public int change(int amount, int[] coins) {

        int M = coins.length + 1;
        int N = amount + 1;

        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < N; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i-1][j] + ( (j < coins[i-1]) ? 0: dp[i][j-coins[i-1]] );
            }
        }

        return dp[M-1][N-1];
    }

//    public int numCoinChanges(int amount, Set<Integer> coinSet){
//
//    }

}
