package leetcode.easy;

import java.util.*;

//[1,1,2,2,3,3]
//[1,1,2,3]
//[6,6,6,6]
//[6,4]
//[1,2,3,4,5,6,7,8,9,10,-1,-2,-10000,23,-19,17,-976,0]
public class L575DistributeCandies {

    public int distributeCandies(int[] candyType) {

        Set<Integer> candies = new HashSet<>();

        for( int i = 0; i < candyType.length; i++ ){
            candies.add(candyType[i]);
        }

        return Math.min(candies.size(), candyType.length / 2);

    }
}
