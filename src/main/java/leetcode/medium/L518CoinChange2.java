package leetcode.medium;

import java.util.*;

public class L518CoinChange2 {

    //     public int change(int amount, int[] coins) {

//         int M = coins.length + 1;
//         int N = amount + 1;
//
//         int[][] dp = new int[M][N];
//
//         for (int i = 0; i < M; i++) {
//             dp[i][0] = 1;
//         }
//
//         for (int j = 0; j < N; j++) {
//             dp[0][j] = 0;
//         }
//
//         for (int i = 1; i < M; i++) {
//             for (int j = 1; j < N; j++) {
//                 dp[i][j] = dp[i-1][j] + ( (j < coins[i-1]) ? 0: dp[i][j-coins[i-1]] );
//             }
//         }
//
//         return dp[M-1][N-1];
//     }

    int count = 0;

    Set<String> coinSet = new HashSet<>();

    public int change(int amount, int[] coins) {

        int[] freqArr = new int[10000];

        int count = change(amount, coins, freqArr);

        return count;
    }

    public int change(int amount, int[] coins, int[] freqArr) {

        for( int coin: coins ){

            if( coin > amount ) continue;


            int[] newFreqArr = freqArr.clone();

            newFreqArr[coin]++;

            if( amount == coin ) {
                coinSet.add(Arrays.toString(newFreqArr));
                continue;
            }

            change(amount-coin, coins, newFreqArr);
        }

        return coinSet.size();

    }


}
