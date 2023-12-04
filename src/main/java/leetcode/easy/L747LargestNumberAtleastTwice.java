package leetcode.easy;

import java.util.*;

//[3,6,1,0]
//[1,2,3,4]
//[1,2]
//[3,4]
//[1,5]
//[7,15,16,94]
//[1,0]
//[0,100]
public class L747LargestNumberAtleastTwice {

    public int dominantIndex(int[] nums) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for( int i = 0; i < nums.length; i++ ){
            maxHeap.add(nums[i]);
        }

        int max = maxHeap.poll();
        int second = maxHeap.poll();

        if( max >= 2*second ){
            for( int i = 0; i < nums.length; i++ ){
                if( max == nums[i] ) return i;
            }
        }

        return -1;
    }
}
