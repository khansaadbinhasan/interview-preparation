package leetcode.easy;

import java.util.*;

public class L2206DivideArrayIntoEqualPairs {

    public boolean divideArray(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            if( !freqMap.containsKey(nums[i]) ) freqMap.put(nums[i], 0);

            freqMap.put(nums[i], freqMap.get(nums[i])+1);
        }

        for( Integer key: freqMap.keySet() ){
            if( freqMap.get(key) % 2 != 0 ) return false;
        }

        return true;
    }

}
