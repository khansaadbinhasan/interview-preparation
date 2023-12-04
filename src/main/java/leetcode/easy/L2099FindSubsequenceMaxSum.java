package leetcode.easy;


import java.util.*;

public class L2099FindSubsequenceMaxSum {


    public int[] maxSubsequence(int[] nums, int k) {

        int[] maxSub = new int[k];
        int maxSum = -1000_000;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < nums.length; i++ ){
            maxHeap.add(nums[i]);
        }

        List<Integer> maxes = new ArrayList<>();

        for( int i = 0; i < k; i++ ){
            maxes.add(maxHeap.poll());
        }

        int r = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( maxes.contains(nums[i]) ){
                maxSub[r++] = nums[i];
                maxes.remove(Integer.valueOf(nums[i]));
            }
        }

        return maxSub;
    }

}
