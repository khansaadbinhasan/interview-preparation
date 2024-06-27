package leetcode.medium;

import java.util.*;

//[0,1]
//[0,1,0]
//[1,0,0,1,1,1,0,0,0,1,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1,0,0,0]
//[1,0,0,1]
//[1,1,1,1,1]
//[1,0,0,0,0,0,0]
//[1]
//[0]
public class L525ContiguousSubarray {

    public int findMaxLength(int[] nums) {

        if( nums[0] == 0 ) nums[0] = -1;
        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] == 0 ) nums[i] = nums[i-1]-1;
            else nums[i] = nums[i-1]+1;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        freq.put(0, -1);
        for( int i = 0; i < nums.length; i++ ){
            if( !freq.containsKey(nums[i]) ) freq.put(nums[i], i);
        }

        int maxLen = 0;

        for( int i = nums.length-1; i >= 0; i-- ){
            if( freq.containsKey(nums[i]) ) {
                maxLen = Math.max(maxLen, i-freq.get(nums[i]));
                freq.remove(nums[i]);
            }
        }

        return maxLen;
    }
}
