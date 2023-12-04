package leetcode.easy;

import java.util.Arrays;

//[4,4,2,4,3]
//[1,1,1,1,1]
//[4,7,2,5,3,1]
//[9,7,1,5,3,4]
public class L2475NumUnequealTriplets {

    public int unequalTriplets(int[] nums) {
        int numTriplets = 0;

        for( int i = 0; i < nums.length; i++ ){
            for( int j = 0; j < nums.length; j++ ){
                for( int k = 0; k < nums.length; k++ ){
                    if( nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k] ){
                        numTriplets++;
                    }
                }
            }
        }

        return numTriplets/6;
    }
}
