package leetcode.medium;

//[10,9,2,5,3,7,101,18]
//[0,1,0,3,2,3]
//[7,7,7,7,7,7,7]
//[1]
//[1,2,3,4,5]
//[7,6,5,4,3,2,1]
//[1,2,99,7,6,5,4,3,2,1,3,4,5,7,6,5,4,3,2,1]
public class L300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] maxArr = new int[nums.length];
        int max = 0;

        for( int i = nums.length-1; i >= 0; i-- ){
            int maxI = 0;
            for( int j = i+1; j < nums.length; j++ ){
                if( nums[j] > nums[i] ) maxI = Math.max(maxI, maxArr[j]);
            }

            maxArr[i] = maxI+1;
            max = Math.max(max, maxArr[i]);
        }

        return max;

    }

    public int lengthOfLIS2(int[] nums) {

        int[] lis = new int[nums.length];
        lis[nums.length-1] = 1;
        int maxLIS = 1;

        for( int i = nums.length-2; i >= 0; i-- ){
            int maxLen = 0;
            for( int j = i; j < nums.length; j++ ){
                if( nums[j] > nums[i] ) maxLen = Math.max(maxLen, lis[j]);
            }
            lis[i] = maxLen+1;
            maxLIS = Math.max(maxLIS, lis[i]);
        }

        return maxLIS;
    }

}
