package leetcode.medium;

import java.util.*;

public class L322CoinChange {
    Set<Integer> coinsSet;
    int[] change;

    public int coinChange(int[] coins, int amount) {
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


    Map<Integer, Integer> dp = new HashMap<>();

    public int coinChange2(int[] coins, int amount) {
        return coinChange(coins, amount, 0);
    }

    public int coinChange(int[] coins, int amount, int numCoins){
        if( amount < 0 ) return -1;
        if( amount == 0 ) return numCoins;
        if( dp.containsKey(amount) ) return dp.get(amount);

        int minCoins = Integer.MAX_VALUE;

        for( int i = 0; i < coins.length; i++ ){
            minCoins = Math.min(minCoins, coinChange(coins, amount-coins[i], numCoins+1));
        }

        minCoins = minCoins == Integer.MAX_VALUE ? -1: minCoins;
        // System.out.println(amount + " " + minCoins);
        dp.putIfAbsent(amount, minCoins);
        if( dp.get(amount) > minCoins ) dp.put(amount, minCoins);

        return minCoins;
    }

    public static void main(String[] args) {
        new L322CoinChange().run();
    }

    public void run(){
        System.out.println(coinChange2(new int[]{1,2,5}, 11));
    }

}
