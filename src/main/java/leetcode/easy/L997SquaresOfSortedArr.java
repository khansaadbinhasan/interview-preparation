package leetcode.easy;

import java.util.*;

//[-4,-1,0,3,10]
//[-7,-3,2,3,11]
//[-1]
//[1]
//[-2,-1]
//[1,2]
//[0]
public class L997SquaresOfSortedArr {

    public int[] sortedSquares(int[] nums) {

        int negCount = 0;

        while(negCount < nums.length && nums[negCount] < 0) negCount++;

        int[] nums1 = Arrays.copyOfRange(nums, 0, negCount);
        int[] nums2 = Arrays.copyOfRange(nums, negCount, nums.length);

        return square(merge(modArr(reverse(nums1)), nums2));
    }

    public int[] merge(int[] nums1, int[] nums2){

        int[] nums = new int[nums1.length+nums2.length];

        int pointer1 = 0;
        int pointer2 = 0;

        int i = 0;

        while( pointer1 < nums1.length && pointer2 < nums2.length ){
            if( nums1[pointer1] < nums2[pointer2] ) nums[i++] = nums1[pointer1++];
            else nums[i++] = nums2[pointer2++];
        }

        while( pointer1 < nums1.length ){
            nums[i++] = nums1[pointer1++];
        }

        while( pointer2 < nums2.length ){
            nums[i++] = nums2[pointer2++];
        }

        return nums;
    }

    public int[] reverse(int[] nums){
        for( int i = 0; i < nums.length/2; i++ ){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }

        return nums;
    }

    public int[] modArr(int[] nums){

        for( int i = 0; i < nums.length; i++ ){
            nums[i] = Math.abs(nums[i]);
        }

        return nums;
    }

    public int[] square(int[] nums){

        for( int i = 0; i < nums.length; i++ ){
            nums[i] = nums[i]*nums[i];
        }

        return nums;

    }


}
