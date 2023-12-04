package leetcode.easy;

import java.util.*;

//[1,5,0,3,5]
//[0]
//[1]
//[1,2,3]
//[1,10,9,100,90,99,99,99,1]
//[1,1,0,0,0,0,0,1]
public class L2357MakeZeroBySubtracting {

    public int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            if(nums[i] > 0) set.add(nums[i]);
        }

        return set.size();
    }
}
