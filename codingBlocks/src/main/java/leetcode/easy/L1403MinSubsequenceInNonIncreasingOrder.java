package leetcode.easy;

import java.util.*;

//[4,3,10,9,8]
//[4,4,7,6,7]
//[6]
public class L1403MinSubsequenceInNonIncreasingOrder {

    public List<Integer> minSubsequence(int[] nums) {

        List<Integer> res = new LinkedList<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            heap.offer(nums[i]);
            sum += nums[i];
        }

        int newSum = 0;

        while( sum >= newSum ){
            int top = heap.poll();

            sum -= top;
            newSum += top;
            res.add(top);
        }

        return res;
    }

}
