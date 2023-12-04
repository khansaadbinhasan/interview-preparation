package leetcode.easy;

//[1,1,0,1,1,1]
//[1,0,1,1,0,1]
//[1]
//[0]
//[1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1]
//[1,1,1,1,1,1,1,1,1,1,1,1]
//[0,1,1,1,1,1,0,1,1,1,1,1,1,1,0]
public class L485MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int sum = nums[0];
        int maxSum = sum;

        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] == 1 ){
                sum++;
                maxSum = Math.max(maxSum, sum);
            }

            else if( nums[i] == 0 ){
                sum = 0;
            }
        }

        return maxSum;

    }
}
