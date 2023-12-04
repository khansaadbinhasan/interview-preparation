package leetcode.easy;

import java.util.*;

//[1,1,2]
//[0,0,1,1,1,2,2,3,3,4]
//[]
//[1]
//[1,2,3,4,5,6,66,66]
//[1,1,1,1,1,1,1]

public class L26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int count = 0;

        for( int i = 0; i < nums.length; i++ ){

            if( set.contains(nums[i]) ){
                nums[i] = -1000;
                count++;
                continue;
            }

            set.add(nums[i]);
        }



        for( int i = 0; i < nums.length; i++ ){

            // int pointer1 = 0;
            int j = i;

            while( j < nums.length && nums[j] != -1000 ){
                j++;
            }

            int index1 = j;

            while( j < nums.length && nums[j] == -1000 ){
                j++;
            }

            if( index1 < nums.length && j < nums.length ){
                int temp = nums[index1];
                nums[index1] = nums[j];
                nums[j] = temp;
            }
        }


        return nums.length - count;
    }

}
