package leetcode.easy;

import java.util.*;

public class L169MajorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for( int num: nums ){
            if( freqMap.containsKey(num) ) freqMap.put(num, freqMap.get(num)+1);
            else freqMap.put(num, 1);
        }

        int maxFreq = 0;

        int keyMaj = -1;

        for( int key: freqMap.keySet() ){
            if( freqMap.get(key) > maxFreq ){
                keyMaj = key;
                maxFreq = freqMap.get(key);
            }
        }

        return keyMaj;
    }


}
