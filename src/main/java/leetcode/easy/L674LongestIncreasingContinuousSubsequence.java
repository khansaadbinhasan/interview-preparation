package leetcode.easy;

//[1,3,5,4,7]
//[2,2,2,2,2]
//[1]
//[1,2,3,4,5,6,7]
//[5,4,6,7,2,3,8,9,1,3,2,2,2,22,6,6,6,7,8,9,10]
public class L674LongestIncreasingContinuousSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int p1 = 0;
        int LCIS = 1;

        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] > nums[i-1] ) LCIS = Math.max(LCIS, i-p1+1);
            else p1 = i;
        }

        return LCIS;

    }

}
