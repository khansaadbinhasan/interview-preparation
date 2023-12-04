package leetcode.easy;

import java.util.*;

//[4,2,4]
//[1,2,3,4,5]
//[0,0,0]
//[0,0]
//[43343,1,354545,33434,4,54545,6,7457,8,7,4324,2323,3434]
public class L2395FindSubArraysWithEqualSum {

    public boolean findSubarrays(int[] nums) {

        HashSet<Integer> sums = new HashSet<>();

        for( int i = 1; i < nums.length; i++ ){
            if( sums.contains(nums[i]+nums[i-1]) ) return true;
            sums.add(nums[i]+nums[i-1]);
        }

        return false;
    }
}
