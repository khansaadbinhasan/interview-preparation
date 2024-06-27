package leetcode.medium;

import java.util.*;

//[1,3,4,8,7,9,3,5,1]
//2
//[1,3,3,2,7,3]
//3
//[1,2,3]
//1
//[1,2,3]
//2
//[5,4,3,2,1,6,7,8,9]
//4
//[5,4,3,2,1,6,7,8,9]
//2
public class L2966DivideArrayWithMaxDiff {

    public int[][] divideArray(int[] nums, int k) {

        Arrays.sort(nums);

        int[][] dividedArr = new int[nums.length/3][3];

        int start = nums[0];
        int end = nums[2];

        for( int i = 0; i < nums.length; i+=3 ){
            if( nums[i+2] - nums[i] > k ) return new int[][]{};
            dividedArr[i/3][0] = nums[i];
            dividedArr[i/3][1] = nums[i+1];
            dividedArr[i/3][2] = nums[i+2];
        }

        return dividedArr;
    }

}
