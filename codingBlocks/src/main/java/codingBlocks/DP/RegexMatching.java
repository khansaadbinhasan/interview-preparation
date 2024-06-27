package codingBlocks.DP;

import java.util.Scanner;

public class RegexMatching {

    public static void main(String[] args) {
        new RegexMatching().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String pat = sc.next();

        System.out.println(solve(str, pat)? 1:0);
    }

    public boolean solve(String s, String p){

        int sL = s.length();
        int pL = p.length();

        if( pL == 0 ) return sL == 0;

        boolean[][] dp = new boolean[sL+1][pL+1];

        dp[0][0] = true;

        for (int j = 2; j <= pL; j++) {
            dp[0][j] = (p.charAt(j-1) == '*') && dp[0][j-2];
        }

        for (int j = 1; j <= pL; j++) {
            for (int i = 1; i <= sL; i++) {
                if( (s.charAt(i-1) == p.charAt(j-1)) || p.charAt(j-1) == '.' ){
                    dp[i][j] = dp[i-1][j-1];
                }

                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2] ||
                            ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') &&
                                    dp[i-1][j]);
                }
            }
        }

        return dp[sL][pL];
    }

}
