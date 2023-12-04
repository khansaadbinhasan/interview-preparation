package leetcode.easy;

import java.util.*;

//[1,1,2,2,2,3]
//[2,3,1,3,2]
//[-1,1,-6,4,5,-6,1,4,1]
//[1]
//[1,1,2,-100,100,-100,100]
public class L1636SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {

        int[] freqArr = new int[201];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]+100]++;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        for( int i = 0; i < freqArr.length; i++ ){

            int key = freqArr[i];

            if( !map.containsKey(key) ) map.put(key, new ArrayList<>());

            while( freqArr[i] > 0 ){
                map.get(key).add(i-100);
                freqArr[i]--;
            }

        }

        List<Integer> lst = new ArrayList<>();

        for( int key: map.keySet() ){
            map.get(key).sort(Collections.reverseOrder());
            lst.addAll(map.get(key));
        }

        for( int i = 0; i < lst.size(); i++ ){
            nums[i] = lst.get(i);
        }

        return nums;
    }

}
