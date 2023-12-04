package leetcode.easy;

import java.util.*;

//[-1,1,2,3,1]
//2
//[-6,2,5,-2,-7,-1,3]
//-2
//[1,1]
//3
//[1]
//2
public class L2824CountPairsLessThanTarget {

    public int countPairs(List<Integer> nums, int target) {

        int pairs = 0;

        for( int i = 0; i < nums.size(); i++ ){
            for( int j = i+1; j < nums.size() && i != j; j++ ){
                if( (nums.get(i) + nums.get(j)) < target ) pairs++;
            }
        }

        return pairs;
    }
}
