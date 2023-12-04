package leetcode.easy;

import java.util.*;

//[1,2,2]
//3
//[3,2,3]
//3
//[3,2]
//3
//[3,2,1]
//3
//[3,1,1]
//3
public class L2706BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {

        PriorityQueue<Integer> priceQ = new PriorityQueue<>();

        for( int i = 0; i < prices.length; i++ ){
            priceQ.add(prices[i]);
        }

        int val1 = priceQ.poll();
        int val2 = priceQ.poll();

        if( val1 + val2 > money ) return money;

        return money - (val1+val2);

    }
}
