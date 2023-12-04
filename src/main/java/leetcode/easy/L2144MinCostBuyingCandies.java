package leetcode.easy;

import java.util.*;

//[1,2,3]
//[6,5,7,9,2,2]
//[5,5]
//[1]
//[1,2,3]
//[8,3,2,1,1,1,1,1,1,1,9]
//[8,7,6,5,8]
public class L2144MinCostBuyingCandies {

    public int minimumCost(int[] costList) {

        Integer[] cost = new Integer[costList.length];

        for( int i = 0; i < costList.length; i++ ){
            cost[i] = costList[i];
        }

        Arrays.sort(cost, Comparator.reverseOrder());

        int minCost = 0;

        for( int i = 0; i < cost.length; i++ ){
            minCost += cost[i];

            if( i + 1 < cost.length ){
                minCost += cost[i+1];
            }

            i+=2;
        }

        return minCost;

    }
}
