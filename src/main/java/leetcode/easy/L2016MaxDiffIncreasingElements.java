package leetcode.easy;

//[7,1,5,4]
//[9,4,3,2]
//[1,5,2,10]
//[1,5,2,10,99,33,12,2222,12121,111,332]
//[9,4,3,2,2]
//[1,5,2,10,99,33,12,2222,12121,111,332, 1, 1213313, 98999]
//[2,1]
//[1,2]
public class L2016MaxDiffIncreasingElements {

    public int maximumDifference(int[] nums) {

        int maxDiff = -1;
        int min = nums[0];

        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] > min ){
                maxDiff = Math.max(maxDiff, nums[i] - min);
            }

            min = Math.min(min, nums[i]);
        }

        return maxDiff;
    }
}
