package leetcode.easy;

import java.util.*;


//[4,1,2,3]
//[2,1]
//[2,1,3,5,6]
//[1]
//[1,2]
//[2,1]
//[5,39,33,5,12,27,20,45,14,25,32,33,30,30,9,14,44,15,21]
public class L2164SortEvenAndOddIndices {

    public int[] sortEvenOdd(int[] nums) {

        if( nums.length == 0 ) return nums;

        PriorityQueue<Integer> pq1 = new PriorityQueue();
        PriorityQueue<Integer> pq2 = new PriorityQueue(Collections.reverseOrder());

        for( int i = 0; i < nums.length-1; i+=2 ){
            pq1.add(nums[i]);
            pq2.add(nums[i+1]);
        }

        if( nums.length % 2 != 0 ) pq1.add(nums[nums.length-1]);

        int i = 0;
        while( !pq1.isEmpty() ){
            nums[i] = pq1.poll();
            i += 2;
        }

        i = 1;
        while( !pq2.isEmpty() ){
            nums[i] = pq2.poll();
            i += 2;
        }

        return nums;
    }
}
