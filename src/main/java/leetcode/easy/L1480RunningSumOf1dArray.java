package leetcode.easy;

//[1,2,3,4]
//[1,1,1,1,1]
//[3,1,2,10,1]
//[1]
//[1,2]
//[3,2]
public class L1480RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {

        for( int i = 1; i < nums.length; i++ ){
            nums[i] += nums[i-1];
        }

        return nums;
    }

}
