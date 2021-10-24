package codingBlocks.DP;

import java.util.Arrays;

public class CoinChangeI {

    public int coinChange(int[] coins, int amount) {

        if( amount == 0 ) return 0;

        Arrays.sort(coins);

        int M = coins.length;
        int N = amount+1;

        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < N; j++) {
            dp[0][j] = j % coins[0] == 0 ? j / coins[0]: 0;

            // System.out.println(dp[0][j]);
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if( j < coins[i] ) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]] + 1);

                // System.out.println(i + "," + j + ":" + dp[i][j-1]);
            }
        }

        return dp[M-1][N-1] == 0 ? -1: dp[M-1][N-1];
    }


}
