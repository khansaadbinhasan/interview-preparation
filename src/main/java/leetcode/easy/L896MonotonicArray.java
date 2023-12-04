package leetcode.easy;

//[1,2,2,3]
//[6,5,4,4]
//[1,3,2]
//[0]
//[-100000,0,10000]
public class L896MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        return isIncreasingMonotone(nums) || isDecreasingMonotone(nums);
    }

    public boolean isIncreasingMonotone(int[] nums){
        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] < nums[i-1] ){
                return false;
            }
        }

        return true;
    }

    public boolean isDecreasingMonotone(int[] nums){
        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] > nums[i-1] ){
                return false;
            }
        }

        return true;
    }
}
