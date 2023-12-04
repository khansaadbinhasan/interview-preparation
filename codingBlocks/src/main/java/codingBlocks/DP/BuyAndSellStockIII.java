package codingBlocks.DP;

import java.util.Scanner;

public class BuyAndSellStockIII {

    public static void main(String[] args) {
        new BuyAndSellStockIII().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] prices = new int[N];

        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if( prices.length == 0 ) return 0;

        int[] left = new int[prices.length];
        int lowest = prices[0];

        left[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i-1], prices[i]-lowest);
            lowest = Math.min(lowest, prices[i]);
        }

        int right = 0;
        int ans = 0;
        int highest = 0;

        for (int i = prices.length-1; i >= 0; i--) {
            right = Math.max(right, highest-prices[i]);
            highest = Math.max(highest, prices[i]);
            ans = Math.max(ans, left[i] + right);
        }

        return ans;
    }

}
