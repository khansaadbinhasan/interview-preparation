package leetcode.medium;

import java.util.*;

//[1,4,6,7,8,20]
//[2,7,15]
//[1,2,3,4,5,6,7,8,9,10,30,31]
//[2,7,15]
public class L983MinCostForTickets {

    int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        int[] passes = new int[]{1,7,30};
        Arrays.fill(dp, Integer.MAX_VALUE);

        return minCost(days, costs, passes, 0);
    }

    public int minCost(int[] days, int[] costs, int[] passes, int i){
        if( i == days.length ) return 0;
        if( dp[i] != Integer.MAX_VALUE ) return dp[i];

        for( int j = 0; j < costs.length; j++ ){
            dp[i] = Math.min(dp[i], costs[j]+minCost(days, costs, passes, getNextI(days, i, passes[j])));
        }

        return dp[i];
    }

    public int getNextI(int[] days, int i, int num){
        int start = days[i];
        while( i < days.length ){
            if( days[i] >= start+num ) break;
            i++;
        }

        return i;
    }

}
