package codingBlocks.DP;

import java.util.*;

public class NumPalindromesInString {

    public static void main(String[] args) {
        new NumPalindromesInString().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(numPalindromicSubstring(s));
    }

    public int numPalindromicSubstring(String s){

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n-1; i++) {
            if( s.charAt(i) == s.charAt(i+1) ) dp[i][i+1] = true;
        }

        for (int d = 2; d < n; d++) {
            int i = 0;
            int j = d;

            while( j < n ){
                if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] ) dp[i][j] = true;

                i++; j++;
            }
        }

        int countPalindrome = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( dp[i][j] ) countPalindrome++;
            }
        }

        return countPalindrome;
    }
}