package stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class BuyAndSellStonks {

    public static void main(String[] args) {
        new BuyAndSellStonks().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] prices = new int[N];

        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if( prices.length <= 1 ) return 0;

        int valley = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if( prices[i] - valley > maxProfit ) maxProfit = prices[i] - valley;
            else if( prices[i] < valley ) valley = prices[i];
        }

        return maxProfit;
    }

    public int maxProfitUsingStack(int[] prices) {

        if( prices.length <= 1 ) return 0;

        Stack<Integer> priceStack = new Stack<>();
        priceStack.push(prices[0]);

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int topPrice = priceStack.peek();
            int profitToBe = prices[i] - priceStack.peek();

            if( profitToBe > maxProfit ) maxProfit = profitToBe;
            else if( prices[i] < topPrice ) priceStack.push(prices[i]);
        }

        return maxProfit;
    }

}
