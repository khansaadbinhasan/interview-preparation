package leetcode.easy;

//[8,4,6,2,3]
//[1,2,3,4,5]
//[10,1,1,6]
//[1]
public class L1475FinalPricesWithDiscount {

    public int[] finalPrices(int[] prices) {

        int[] discounts = new int[prices.length];

        for( int i = 0; i < prices.length; i++ ){

            int discount = 0;

            for( int j = i+1; j < prices.length; j++ ){
                if( prices[j] <= prices[i] ){
                    discount = prices[j];
                    break;
                }
            }

            discounts[i] = prices[i] - discount;
        }

        return discounts;
    }

}
