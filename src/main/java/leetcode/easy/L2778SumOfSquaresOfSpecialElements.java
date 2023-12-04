package leetcode.easy;

//[1,2,3,4]
//[2,7,1,19,18,3]
//[1]
//[1,2,3,4,5,6,7,8,9,10]
//[7,6,5,1,2,3,50]
public class L2778SumOfSquaresOfSpecialElements {
    public int sumOfSquares(int[] nums) {

        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums.length % (i+1) == 0 ) sum += nums[i]*nums[i];
        }

        return sum;

    }
}
