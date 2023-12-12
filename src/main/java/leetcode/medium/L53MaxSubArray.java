package leetcode.medium;

import java.util.*;

public class L53MaxSubArray {

    public int maxSubArray(int[] nums) {

        List<Integer> array = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            array.add(nums[i]);
        }


        if( array.size() == 0 ){
            return -1;
        }

        int maxSum = 0;

        for (int i = 0; i < array.size(); i++) {
            maxSum = max(array.get(i), array.get(i) + maxSum);
            array.set(i, maxSum);
//            System.out.println(maxSum + " " + array);
        }

        return maxOfArray(array);

    }


    public int maxOfArray(List<Integer> array){
        int maxNum = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if( array.get(i) > maxNum ){
                maxNum = array.get(i);
            }
        }

        return maxNum;
    }

    public int max(int num1, int num2){
        if( num1 > num2 ){
            return num1;
        }

        return num2;
    }



    public int maxSubArray2(int[] nums) {

        int max = findMax(nums);
        int sum = 0;
        int maxSum = 0;

        if( max <= 0 ) return max;

        for( int i = 0; i < nums.length; i++ ){
            if( (sum + nums[i]) <= 0 ){
                sum = 0;
                continue;
            }

            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public int findMax(int[] nums){
        int max = nums[0];

        for( int i = 0; i < nums.length; i++ ) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }


}
