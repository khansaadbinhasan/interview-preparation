package leetcode.easy;

import java.util.*;

//[1,2,3,3]
//[2,1,2,5,3,2]
//[5,1,5,2,5,3,5,4]
//[1,2,1,3]
//[1,1,2,3]
public class L961RepeatedNums {

    public int repeatedNTimes(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            if( set.contains(nums[i]) ) return nums[i];
            else set.add(nums[i]);
        }

        return -1;
    }

}
