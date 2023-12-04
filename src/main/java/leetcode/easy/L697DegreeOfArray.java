package leetcode.easy;

import java.util.*;

//[1,2,2,3,1]
//[1,2,2,3,1,4,2]
//[1]
//[1,2,3,4,5,6,7,8,9]
//[1,1,1,1,1,1,1]
//[1,5,4,3,2,1,1,1,1,4,4,4,4,4,4,4,4]
//[1,2,3,1,2,3,3,2,1]
//[3,3,3,4,4,4,5,1,1,1]
//[1,2,2,1,2,1,1,1,1,2,2,2]
public class L697DegreeOfArray {

    public static void main(String[] args) {
        new L697DegreeOfArray().run();
    }

    public void run(){
        System.out.println(findShortestSubArray(new int[]{1,2,2,1,2,1,1,1,1,2,2,2}));
    }

    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> freqMap = freqMap(nums);

        int maxFreq = 0;

        for(int key: freqMap.keySet()){
            maxFreq = Math.max(maxFreq, freqMap.get(key));
        }

        Set<Integer> maxFreqSet = new HashSet<>();

        for(int key: freqMap.keySet()){
            if(freqMap.get(key) == maxFreq){
                maxFreqSet.add(key);
            }
        }

        Map<Integer, Integer> diffMap = diffMap(nums);

        int min = 100_000;

        for( int num: nums ){
            if( maxFreqSet.contains(num) && diffMap.get(num) < min ){
                min = diffMap.get(num);
            }
        }

        return min;

    }

    public Map<Integer, Integer> freqMap(int[] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            if (!freqMap.containsKey(num)) {
                freqMap.put(num, 0);
            }

            freqMap.put(num, freqMap.get(num) + 1);
        }

        return freqMap;
    }

    public Map<Integer, Integer> diffMap(int[] nums){
        Map<Integer, Integer> minMap = new HashMap<>();
        Map<Integer, Integer> maxMap = new HashMap<>();
        Map<Integer, Integer> diffMap = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            if( !minMap.containsKey(nums[i]) ){
                minMap.put(nums[i], i);
            }
        }

        for( int i = 0; i < nums.length; i++ ){
            maxMap.put(nums[i], i);
        }

        for( int key: minMap.keySet() ){
            diffMap.put(key, maxMap.get(key)-minMap.get(key)+1);
        }

        return diffMap;
    }
}
