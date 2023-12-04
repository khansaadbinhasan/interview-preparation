package leetcode.easy;

//[2,3,-1,8,4]
//[1,-1,4]
//[2,5]
public class L1991FindMiddleIndex {

    public int findMiddleIndex(int[] nums) {

        int middleIndex = nums.length;

        for( int i = 0; i < nums.length; i++ ){
            int leftSum = 0;
            int rightSum = 0;

            for( int j = 0; j < i; j++ ){
                leftSum += nums[j];
            }

            for( int j = i+1; j < nums.length; j++ ){
                rightSum += nums[j];
            }

            if( leftSum == rightSum && i < middleIndex ){
                middleIndex = i;
            }
        }

        return middleIndex == nums.length ? -1: middleIndex;

    }
}
