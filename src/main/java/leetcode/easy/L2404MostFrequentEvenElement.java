package leetcode.easy;

import java.util.*;

//[0,1,2,2,4,4,1]
//[4,4,4,9,2,4]
//[29,47,21,41,13,37,25,7]
//[1,2,3,4]
//[1]
//[2]
//[2,2,2,2,2,2,4]
//[4,4,4,2,2,2]
public class L2404MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] % 2 != 0 ) continue;

            if( freqMap.get(nums[i]) == null ){
                freqMap.put(nums[i], 0);
            }

            freqMap.put(nums[i], freqMap.get(nums[i])+1);
        }


        int max = 0;

        for( int key: freqMap.keySet() ){
            max = Math.max(max,freqMap.get(key));
        }

        int currKey = 1000_000;

        for( int key: freqMap.keySet() ){
            if( freqMap.get(key) == max ){
                currKey = Math.min(currKey, key);
            }
        }

        if( currKey == 1000_000 ) return -1;

        return currKey;
    }
}
