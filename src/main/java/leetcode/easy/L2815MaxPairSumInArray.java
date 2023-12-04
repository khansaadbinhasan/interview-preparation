package leetcode.easy;

import java.util.*;

//[51,71,17,24,42]
//[1,2,3,4]
//[1,1]
//[12,23,21,22,25,56,29]
//[1,2,3,4,5,6,7,8,9,12,21,23,24,99,99,9,999,99,88,999,1,2,3,4,5,6,7,8,9,12,21,23,24,99,99,9,999,99,88,999,1000,12,21,23,24,99,99]
public class L2815MaxPairSumInArray {

    public int maxSum(int[] nums) {

        int maxSum = -1;
        PriorityQueue<Integer>[] maxDigits = new PriorityQueue[10];

        for( int i = 0; i < maxDigits.length; i++ ){
            maxDigits[i] = new PriorityQueue(Comparator.reverseOrder());
        }

        for( int i = 0; i < nums.length; i++ ){
            maxDigits[getGreatestDigit(nums[i])].add(nums[i]);
        }

        for( int i = 0; i < maxDigits.length; i++ ){
            if( !maxDigits[i].isEmpty() ){
                int sum = maxDigits[i].poll();

                if( !maxDigits[i].isEmpty() ){
                    sum += maxDigits[i].poll();
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }

        return maxSum;
    }

    public int getGreatestDigit(int num){
        int dig = 0;

        while( num != 0 ){
            dig = Math.max(dig, num%10);
            num = num / 10;
        }

        return dig;
    }
}
