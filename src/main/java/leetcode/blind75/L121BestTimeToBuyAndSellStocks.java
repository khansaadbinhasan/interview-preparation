package leetcode.blind75;

// [7,1,5,3,6,4]
//[7,6,4,3,1]
//[1]
//[1,2]
//[3,4,2,1,0,1,50]
public class L121BestTimeToBuyAndSellStocks {

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

    public int maxProfit2(int[] prices) {
        int maxProf = 0;

        int[] min = new int[prices.length];
        int[] max = new int[prices.length];

        min[0] = prices[0];
        max[prices.length-1] = prices[prices.length-1];

        for( int i = 1; i < prices.length; i++ ){
            min[i] = Math.min(min[i-1], prices[i]);
        }

        for( int i = prices.length-2; i >= 0; i-- ){
            max[i] = Math.max(max[i+1], prices[i]);
        }

        for( int i = 0; i < prices.length; i++ ){
            maxProf = Math.max(maxProf, max[i]-min[i]);
        }

        return maxProf;
    }
}
