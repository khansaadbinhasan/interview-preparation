package leetcode.easy;

//[10,4,8,3]
//[1]
//[2]
//[1,2]
//[3,4,1]
//[1,2,3,4,5,9,100,70,43,32,21]
public class L2547LeftAndRightSumDifference {

    public int[] leftRightDifference(int[] nums) {

        if( nums.length == 1 ) return new int[]{0};

        int[] leftSum = nums.clone();
        int[] rightSum = nums.clone();

        leftSum[0] = 0;
        rightSum[rightSum.length-1] = 0;

        for( int i = 1; i < nums.length; i++ ){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        for( int i = nums.length-2; i >= 0; i-- ){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for( int i = 0; i < nums.length; i++ ){
            nums[i] = Math.abs(leftSum[i]-rightSum[i]);
        }

        return nums;

    }

}
