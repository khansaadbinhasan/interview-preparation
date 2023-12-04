package leetcode.easy;

//[1,2,3,4,5]
//3
//[5,5,5]
//2
//[5]
//5
//[100,5,6,7,8,100]
//1
//[100,5]
//100
public class L2656MaxSumElements {

    public int maximizeSum(int[] nums, int k) {

        int max = nums[0];

        for( int i = 1; i < nums.length; i++ ){
            max = Math.max(max, nums[i]);
        }

        return max*k + k*(k-1) / 2;
    }
}
