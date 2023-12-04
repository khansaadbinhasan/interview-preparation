package leetcode.easy;

//[1,15,6,3]
//[1,2,3,4]
//[2]
//[1]
//[1,2,1,1,1]
public class L2535DifferenceSum {

    public int differenceOfSum(int[] nums) {
        return Math.abs(elementSum(nums) - digitSum(nums));
    }

    public int elementSum(int[] nums){
        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            sum += nums[i];
        }

        return sum;
    }

    public int digitSum(int num){
        int sum = 0;

        while( num != 0 ){
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }

    public int digitSum(int[] nums){
        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            sum += digitSum(nums[i]);
        }

        return sum;
    }
}
