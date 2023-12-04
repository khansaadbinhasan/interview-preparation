package leetcode.easy;

import java.util.*;

//[1,4,3,2]
//[6,2,6,5,1,2]
public class L561ArrPartition1 {

    //     public int arrayPairSum(int[] nums) {
//         PriorityQueue<Integer> codingBlocks.heap = new PriorityQueue<>(Collections.reverseOrder());

//         for( int i = 0; i < nums.length; i++ ){
//             codingBlocks.heap.offer(nums[i]);
//         }

//         int sum = 0;

//         for( int i = 0; i < nums.length / 2; i++ ){
//             codingBlocks.heap.poll();
//             sum += codingBlocks.heap.poll();
//         }

//         return sum;
//     }

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            sum = sum + (i % 2 != 0? 0: nums[i]);
        }

        return sum;
    }


}
