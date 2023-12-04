package leetcode.easy;

import java.util.Arrays;

//[11,7,2,15]
//[-3,3,3,90]
//[3,3,3,3]
//[1,1,3,3,3,20,20]
//[20,1,3,1,3,3,20]
//[1]
//[1,2]
//[1,2,3]
public class L2148CountStrictlyGreaterElems {

    public int countElements(int[] nums) {
        if( nums.length < 3 ) return 0;

        Arrays.sort(nums);

        int numElems = 0;

        if( nums[0] != nums[1] && nums[nums.length-1] != nums[nums.length-2] ){
            return nums.length-2;
        }

        int i = 0;

        while( i < nums.length && nums[0] == nums[i] ) {
            i++;
        }

        i--;

        int j = nums.length-1;

        while( j >= 0 && nums[nums.length-1] == nums[j] ) {
            j--;
        }

        j++;

        if( j > i ) return j-i-1;

        return numElems;
    }


}
