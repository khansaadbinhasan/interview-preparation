package leetcode.easy;

import java.util.*;

public class L2367ArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {

        int triplets = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( isContainedInArr(nums, nums[i]+diff) ){
                if( isContainedInArr(nums, nums[i] + diff*2) ){
                    triplets++;
                }
            }
        }

        return triplets;
    }

    public boolean isContainedInArr(int[] nums, int num){
        int bstIndex = Arrays.binarySearch(nums, num);
        return bstIndex > 0 && bstIndex < nums.length;
    }
}
