package leetcode.medium;

import java.util.*;

public class L2370LongestIdealSubsequence {

    public static void main(String[] args) {
        new L2370LongestIdealSubsequence().run();
    }

    public void run(){
        System.out.println(longestIdealString("abdjabfjadjkfhgadsjkhfjkadshppowepuroiqeytuyerwui", 2));
    }

    int[][] dp;

    public int longestIdealString(String s, int k) {
        dp = new int[s.length()][s.length()];

        Arrays.fill(dp, -1);

        int maxLen = 0;

        for( int i = 0; i < s.length(); i++ ){
            maxLen = Math.max(maxLen, ideal(s.substring(i,i+1),k,s,i+1));
        }

        return maxLen;
    }

    public int ideal(String t, int k, String s, int i){
        if( i >= s.length() ) return t.length();
        if( dp[i][0] != -1 ) return dp[i][0];

        if( Math.abs(t.charAt(t.length()-1) - s.charAt(i)) <= k ){
            return dp[i][0] = Math.max(ideal(t+s.charAt(i), k, s, i+1),ideal(t, k, s, i+1));
        }

        return dp[i][0] = ideal(t, k, s, i+1);
    }


}
