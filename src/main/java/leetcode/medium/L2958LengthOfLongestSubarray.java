package leetcode.medium;

import java.util.*;

//[1,2,3,1,2,3,1,2]
//2
//[1,2,1,2,1,2,1,2]
//1
//[5,5,5,5,5,5,5]
//4
//[1]
//1
//[1,2,3,3,2,1]
//2
//[1,2,3,3,2,1,4,3,2,1]
//1
//[1,2,3,4,3,2,1,5,4,3]
//5
//[1,2,3,1,2,3,3,2,1,4,3,2,1,1,2,3,3,2,1,4,3,2,1,4,3,2,1,5,1,2,3,1,2,3,3,2,1,4,3,2,1,1,2,3,3,2,1,4,3,2,1,3,2,1,4,3,2,1,4,3,1,2,3,3,2,1,4,3,2,1]
//7
public class L2958LengthOfLongestSubarray {

    public static void main(String[] args) {
        new L2958LengthOfLongestSubarray().run();
    }

    public void run(){
        System.out.println(maxSubarrayLength(new int[]{1,2,3,3,2,1,4,3,2,1}, 1));
    }

    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxLen = 1;

        int p1 = 0;
        int p2 = 1;

        freqMap.put(nums[p1], 1);

        while( p1 <= p2 && p2 < nums.length ){
            freqMap.putIfAbsent(nums[p2], 0);
            if( freqMap.get(nums[p2]) == k ) {
                freqMap.put(nums[p1], freqMap.get(nums[p1])-1);
                p1++;
                continue;
            }
            freqMap.put(nums[p2], freqMap.get(nums[p2])+1);
            maxLen = Math.max(maxLen, p2-p1+1);
            p2++;
        }

        return maxLen;
    }

}
