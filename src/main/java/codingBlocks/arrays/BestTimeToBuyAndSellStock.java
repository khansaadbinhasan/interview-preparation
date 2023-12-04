package codingBlocks.arrays;


//7,1,5,3,6,4
//7,6,4,3,1
//7,6,1,3,1
//7,6,1,3,10
//1
//1,2
//4,2
//4,100,1
//1,2,3,4,7,5,4,3,2,1
//1,100,3,4,1000
//2,7,1,4
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().run();
    }

    public void run(){
        System.out.println(maxProfit(new int[]{2,7,1,4}));
    }

    public int maxProfit(int[] prices) {
        int left = 1;
        int right = prices.length-2;
        int finalLeft = 0;
        int finalRight = prices.length-1;

        while( right >= 0 && right > finalLeft ){

            if( prices[left] < prices[finalLeft] && left < finalRight ) finalLeft = left;
            if( prices[right] > prices[finalRight] && right > finalLeft ) finalRight = right;

            System.out.println(finalLeft + " " + finalRight);

            left++; right--;
        }

        if( prices[finalRight] > prices[finalLeft] ) return prices[finalRight] - prices[finalLeft];

        return 0;
    }

}
