package leetcode.easy;

import java.util.*;

//[-1,2,-3,3]
//[-1,10,6,7,-7,1]
//[-10,8,6,7,-2,-3]
//[-1]
//[1,-1]
//[-1000,-999,2,-2,3,-3,999]
public class L2441LargestPostiveNegativeNumbers {

    public int findMaxK(int[] nums) {

        Set<Integer> intSet = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            intSet.add(nums[i]);
        }

        int max = -2000;

        for( Integer key: intSet ){
            if( intSet.contains(-key) ){
                max = Math.max(max, Math.abs(key));
            }
        }

        return max == -2000? -1: max;

    }

    public int findMaxK2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        boolean found = false;

        for( int i = 0; i < nums.length; i++ ){
            set.add(nums[i]);
        }

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] >= max && set.contains(-nums[i]) ) {
                max = nums[i];
                found = true;
            }
        }

        return found ? max: -1;
    }
}
