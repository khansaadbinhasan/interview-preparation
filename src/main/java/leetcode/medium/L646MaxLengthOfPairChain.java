package leetcode.medium;

import java.util.*;

public class L646MaxLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[0], p2[0]));

        int longestChain = 1;
        int[] dp = new int[pairs.length];
        dp[pairs.length-1] = 1;

        for( int i = pairs.length-2; i >= 0; i-- ){
            int curr = 0;
            for( int j = i+1; j < dp.length; j++ ){
                if( pairs[j][0] > pairs[i][1] ) curr = Math.max(curr, dp[j]);
            }
            dp[i] = curr+1;
            longestChain = Math.max(dp[i], longestChain);
        }

        return longestChain;
    }
}
