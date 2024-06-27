package leetcode.medium;

import java.util.*;

public class L2870MinOpsToMakeArrayEmpty {

    public int minOperations(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            if( !freqMap.containsKey(nums[i]) ) freqMap.put(nums[i], 0);

            freqMap.put(nums[i], freqMap.get(nums[i])+1);
        }

        int minOps = 0;

        for( Integer key: freqMap.keySet() ){
            int ops = getOps(freqMap.get(key));
            if( ops == -1 ) return -1;
            minOps += ops;
        }


        return minOps;
    }

    public int getOps(int val){
        if( val % 3 == 0 ) return val / 3;

        int temp = val;

        while( temp > 0 ) {
            temp -= 2;

            if( temp % 3 == 0 ) return ((val-temp)/2) + temp/3;
            if( temp == 0 ) return val / 2;
        }

        return -1;
    }

}
