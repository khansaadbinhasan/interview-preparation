package leetcode.easy;

//[-3,2,-3,4,2]
//[1,2]
//[1,-2,-3]
//[-100,-10,-90,-100]
//[-100]
//[-1]
//[0]
//[5,6,7,8]
public class L1413MinValueToGetPositiveStepSum {

    public int minStartValue(int[] nums) {

        int min = 0;
        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            sum += nums[i];
            min = Math.min(min, sum);
        }

        return Math.abs(min) + 1;
    }

}
