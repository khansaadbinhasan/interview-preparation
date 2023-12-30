package leetcode.medium;

import java.util.*;

//[1,2,5]
//11
//[1]
//0
//[5]
//1
//[10,3,4,1,5,4,3,2,1]
//7
//[2]
//3
//[5,3,2,1]
//3
//[9,8,7,6,5,4,3,2,1]
//100
//[98,100,99,18,16,10000,12121]
//10000
//[98,100,99,18,16,100,12121]
//10000
//[186,419,83,408]
//6249
public class L322CoinChange {


    public static void main(String[] args) {
        new L322CoinChange().run();
    }

    public void run(){
        System.out.println(coinChange(new int[]{98,100,99,18,16,100,12121}, 10000));
    }


// public int coinChange(int[] coins, int amount) {
    // }

    Set<String> coinSet = new HashSet<>();

    public int coinChange(int[] coins, int amount) {

        int[] freqArr = new int[Integer.MAX_VALUE];

        int minCoin = Integer.MAX_VALUE;

        change(amount, coins, freqArr);

        for( String c: coinSet ){
            minCoin = Math.min(minCoin, c.split(",").length);
        }

        return minCoin;
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


    int[] dp;

    public int coinChangeTopDown(int[] coins, int amount) {
        dp = new int[amount+1];

        return cc(coins, amount);
    }

    public int cc(int[] coins, int amount) {
        if( amount < 0 ) return -1;
        if( amount == 0 ) return 0;
        if( dp[amount] != 0 ) return dp[amount];

        int min = Integer.MAX_VALUE;
        boolean isMinUpdated = false;

        for( int i = 0; i < coins.length; i++ ){
            int cc = cc(coins, amount-coins[i]);

            if( cc < 0 ) continue;

            if( cc < min ){
                min = cc + 1;
                isMinUpdated = true;
            }
        }

        return dp[amount] = (isMinUpdated ? min: -1);
    }


    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, amount+1);
        boolean isUpdate = false;

        dp[0] = 0;

        for( int i = 1; i <= amount; i++ ){
            for( int j = 0; j < coins.length; j++ ){
                if( i-coins[j] >= 0 ) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1: dp[amount];
    }

    public int coinChange5(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, amount+1);
        boolean isUpdate = false;

        dp[0] = 0;

        for( int i = 1; i <= amount; i++ ){
            for( int j = 0; j < coins.length; j++ ){
                if( i-coins[j] >= 0 ) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1: dp[amount];
    }


    Set<Integer> coinsSet;
    int[] change;

    public int coinChange1(int[] coins, int amount) {
        coinsSet = new HashSet<>();
        change = new int[amount+1];
        Arrays.fill(change, -2);

        for( int i = 0; i < coins.length; i++ ){
            coinsSet.add(coins[i]);
        }

        return coinChangeRec(coins, amount);
    }

    public int coinChangeRec(int[] coins, int amount){
        if( amount == 0 ) return 0;
        if( amount < 0 ) return -1;
        if( change[amount] != -2 ) return change[amount];
        if( coinsSet.contains(amount) ) return 1;

        int min = Integer.MAX_VALUE;

        for( int i = 0; i < coins.length; i++ ){
            int val = coinChangeRec(coins, amount-coins[i]);
            if( val != -1 ) min = Math.min(min, val+1);
        }

        return change[amount] = (min == Integer.MAX_VALUE ? -1: min);
    }


}
