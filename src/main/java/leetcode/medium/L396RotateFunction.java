package leetcode.medium;

import java.util.*;

//[4,3,2,6]
//[100]
//[1]
//[-1,-2,-3,5,55,100,-100,1,9,7,6,54,32,4,3,0,9,-100,-9,-65,19,65,44,-98]
//[5,4,3,2,1,0]
//[0,1,2,3,4,5]
public class L396RotateFunction {
    int[] sum;

    public int maxRotateFunction(int[] nums) {
        sum = nums.clone();
        int sum0 = 0;

        for(int i = 1; i < nums.length; i++ ){
            sum[i] += sum[i-1];
        }

        // System.out.println(Arrays.toString(sum));

        for( int i = 0; i < nums.length; i++ ){
            sum0 += nums[i]*i;
        }

        int maxSum = sum0;

        for( int i = 1; i < nums.length; i++ ){
            maxSum = Math.max(maxSum, getSum(i, nums, sum0));
        }

        return maxSum;
    }

    // public int sum(int ind, int[] nums){
    //     int sum = 0;

    //     for(int i = 0; i <= ind; i++ ){
    //         sum += nums[i];
    //     }

    //     return sum;
    // }

    public int getSum(int k, int[] nums, int sum0){
        return sum0 + nums.length*sum[k-1] - k*sum[nums.length-1];
    }
}
