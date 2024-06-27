package leetcode.hard;

import java.util.*;

//[4,1]
//5
//2
//[2,3,3,3,5]
//2
//1
//[3,5,3]
//1
//3
//[1,14,14,15]
//2
//1
public class L3139MinCostToEqualizeArray {

    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        return makeEqual(nums, cost1, cost2, 0);
    }

    public int makeEqual(int[] nums, int cost1, int cost2, int totalCost){
        int notEqualCount = 0;
        int[] indices = new int[2];
        for( int i = 0; i < nums.length; i++ ){
            int maxFreq = getMaxFreq(nums);
            if( nums[i] != maxFreq ) {
                indices[notEqualCount++] = i;
                if( notEqualCount == 2 ) break;
            }
        }


        if( notEqualCount == 1 ) {
            int[] numsClone = nums.clone();
            numsClone[indices[0]]++;
            return makeEqual(numsClone, cost1, cost2, totalCost + cost1)%(1000_000_000 + 7);
        }

        if( notEqualCount == 2 ) {
            int[] numsClone = nums.clone();
            numsClone[indices[0]]++;
            int tCost1 = makeEqual(numsClone, cost1, cost2, totalCost + cost1);

            numsClone = nums.clone();
            numsClone[indices[1]]++;
            int tCost3 = makeEqual(numsClone, cost1, cost2, totalCost + cost1);

            numsClone = nums.clone();
            numsClone[indices[0]]++;
            numsClone[indices[1]]++;
            int tCost2 = makeEqual(numsClone, cost1, cost2, totalCost + cost2);

            return Math.min(tCost3, Math.min(tCost1, tCost2))%(1000_000_000 + 7);
        }


        return totalCost%(1000_000_000 + 7);
    }

    public int getMaxFreq(int[] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            freqMap.putIfAbsent(nums[i], 0);
            freqMap.put(nums[i], freqMap.get(nums[i])+1);
        }

        int maxFreq = nums[0];

        for( int key: freqMap.keySet() ){
            if( freqMap.get(key) > freqMap.get(maxFreq) ){
                maxFreq = key;
            }
        }

        return maxFreq;
    }
}
