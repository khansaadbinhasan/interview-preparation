package leetcode.easy;

import java.util.*;

//[2,3,5,1,3]
//3
//[4,2,1,1,2]
//1
//[12,1,12]
//10

public class L1431KidsWithGreatestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = -1;

        for( int i = 0; i < candies.length; i++ ){
            max = Math.max(max, candies[i]);
        }

        List<Boolean> result = new LinkedList<>();

        for( int i = 0; i < candies.length; i++ ){
            result.add(candies[i] + extraCandies >= max ? true: false);
        }

        return result;
    }
}
