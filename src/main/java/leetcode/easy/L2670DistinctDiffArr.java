package leetcode.easy;

import java.util.*;

//[1,2,3,4,5]
//[3,2,3,4,2]
//[1]
//[3,3,3,3,3]
//[3,2,3,2,3,1]
public class L2670DistinctDiffArr {

    public int[] distinctDifferenceArray(int[] nums) {

        int[] distinctCount = new int[nums.length];

        for( int i = 0; i < distinctCount.length; i++ ){
            distinctCount[i] = distinctCountLeft(nums, i) - distinctCountRight(nums, i);
        }

        return distinctCount;
    }

    //left distinct
    public int distinctCountLeft(int[] nums, int i){

        HashSet<Integer> numSet = new HashSet<>();

        for( int k = 0; k <= i; k++ ){
            numSet.add(nums[k]);
        }

        return numSet.size();
    }

    //right distinct
    public int distinctCountRight(int[] nums, int i){
        HashSet<Integer> numSet = new HashSet<>();

        for( int k = i+1; k < nums.length; k++ ){
            numSet.add(nums[k]);
        }

        return numSet.size();
    }}
