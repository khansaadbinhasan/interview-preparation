package leetcode.easy;

//[10,20,30,5,10,50]
//[10,20,30,40,50]
//[12,17,15,13,10,11,12]
//[100,10,1]
public class L1800AscendingSum {

    public int maxAscendingSum(int[] nums) {

        int pointer1 = 0;
        int pointer2 = 0;

        int sum = nums[0];
        int maxSum = sum;

        for( int i = 1; i < nums.length; i++ ){

            if( nums[i] > nums[pointer2] ){
                pointer2 = i;

                sum = findSum(nums, pointer1, pointer2);

                maxSum = Math.max(maxSum, sum);
            }
            else {
                pointer1 = pointer2 = i;

                sum = 0;
            }
        }

        return maxSum;

    }

    //both inclusive
    public int findSum(int[] nums, int pointer1, int pointer2){

        int sum = 0;

        for( int i = pointer1; i <= pointer2; i++ ){
            sum += nums[i];
        }

        return sum;
    }

}
