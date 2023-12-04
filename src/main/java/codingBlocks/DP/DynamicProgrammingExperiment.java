package codingBlocks.DP;

import java.util.Arrays;

public class DynamicProgrammingExperiment {

    public static void main(String[] args) {
        new DynamicProgrammingExperiment().run();
    }

    public void run(){
        int n = 101;
        int[] a = new int[]{5,7,1};
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);
//        dp[0] = 0;

        System.out.println(minCoins(n, a, dp));
    }

    public int minCoins(int n, int a[], int[] dp){

        if( n == 0 ) return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < a.length ; i++) {
            int subAns = Integer.MAX_VALUE/2;

            if( n-a[i] >= 0 ) {
                if( dp[n-a[i]] != -1 ) subAns = dp[n-a[i]];
                else subAns = minCoins(n-a[i], a, dp);
            }

            ans = Math.min(ans, subAns+1);
        }

        dp[n] = ans;

        return ans;
    }

}
