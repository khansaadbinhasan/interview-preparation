package leetcode.easy;

import java.util.*;

//[90]
//1
//[9,4,1,7]
//2
//[9,4,1,7,8,1,1,1,1,1,888,21211,11]
//3
//[9,4,1,1,10,11,111,19,888,21211,11]
//5
//[9]
//1
//[9,8]
//1
//[9,4,1,1,10,11,111,19,888,21211,11,6767,232,2323,2221,11,1323,2,32,323]
//1
//[9,4,1,1,10,11,111,19,888,21211,11,6767,232,2323,2221,11,1323,2,32,323]
//10
public class L1984MinDiffBetweenHighestLowest {

    public int minimumDifference(int[] nums, int k) {

        Integer[] numsInt = new Integer[nums.length];

        for( int i = 0; i < nums.length; i++ ){
            numsInt[i] = nums[i];
        }

        Arrays.sort(numsInt, Comparator.reverseOrder());

        int minDiff = numsInt[0] - numsInt[k-1];

        for( int i = 0; i <= numsInt.length - k; i++ ){
            minDiff = Math.min(minDiff, numsInt[i] - numsInt[i+k-1]);
        }

        return minDiff;
    }
}
