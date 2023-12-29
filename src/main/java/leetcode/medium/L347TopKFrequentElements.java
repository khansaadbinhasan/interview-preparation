package leetcode.medium;

import java.util.*;

public class L347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if( freqMap.containsKey(nums[i]) ) freqMap.put(nums[i], freqMap.get(nums[i])+1);
            else freqMap.put(nums[i], 1);
        }

        int maxFreq = Integer.MIN_VALUE;

        for( int key: freqMap.keySet() ){
            if( freqMap.get(key) > maxFreq ) maxFreq = freqMap.get(key);
        }

        int[] freqArr = new int[maxFreq];

        Arrays.fill(freqArr, 0);

        for( int key: freqMap.keySet() ){
            if( freqArr[freqMap.get(key)-1] == 0 ) freqArr[freqMap.get(key)-1] = 1;
            else freqArr[freqMap.get(key)-1]++;
        }

        int minFreq = Integer.MAX_VALUE;
        int count = 0;

        for (int i = freqArr.length-1; i >= 0 ; i--) {
            if( freqArr[i] + count <= k ) {
                count += freqArr[i];
                minFreq = i+1;
            }
            else break;
        }

        int[] kFreqList = new int[k];

        int index = 0;

        for( int key: freqMap.keySet() ){
            if( freqMap.get(key) >= minFreq && index < kFreqList.length ) {
                kFreqList[index] = key;
                index++;
            }
        }

        return kFreqList;
    }

    //arr = [1,1,1,2,2,3] → 10^8 → FreqMap
    //freqArr = [3,2,1] ->(Add 10^4 to get index) -> here 0th index is 1, 2,3 etc.
    //freqArrList = [[3],[2],[1],[],[]] → How many elements we have that have given frequency → O(n)

    //ans = int[k];

    //r = 0;
    //ans[r++] = freqArrList[i]; → i iters from last to 0

    //O(n)
    //O(10^8)

    //1,1,1,2,2,3, k=2
    //…0,0,3,2,1,0,0…
    //[..[],[],[3],[2],[1],[],[],..]
    //[1,2]
//    public int[] topKFrequent2(int[] nums, int k) {
//        int[] kFreqElements = new int[k];
//        int[] freqArr = new int[1000_00_000];
//        for( int i = 0; i < nums.length; i++ ){
//            freqArr[nums[i]+10000]++;
//        }
//
//        List[] freqArrList = new ArrayList[n];
//
//        for( int i = 0; i < freqArrList.length; i++ ){
//            freqArrList[i] = new ArrayList<Integer>();
//        }
//
//        for( int i = 0; i < freqArr.length; i++ ){
//            if( freqArr[i] > 0 ) freqArrList[i].add(i-10000);
//        }
//
//        int r = 0;
//
//        for( int i = freqArrList.length-1; i >= 0; i-- ){
//            int j = 0;
//            while( r < k && j < freqArrList[i].size() ){
//                kFreqElements[r] = freqArrList[i].get(j);
//                r++;
//                j++;
//            }
//        }
//
//        return kFreqElements;
//    }

    //arr = [1,1,1,2,2,3] → 10^8 → FreqMap
    //freqArr = [3,2,1] ->(Add 10^4 to get index) -> here 0th index is 1, 2,3 etc.
    //freqArrList = [[3],[2],[1],[],[]] → How many elements we have that have given frequency → O(n)

    //ans = int[k];

    //r = 0;
    //ans[r++] = freqArrList[i]; → i iters from last to 0

    //O(n)
    //O(10^8)

    //1,1,1,2,2,3, k=2
    //…0,0,3,2,1,0,0…
    //[..[],[],[3],[2],[1],[],[],..]
    //[1,2]
    public int[] topKFrequent2(int[] nums, int k) {
        int[] kFreqElements = new int[k];
        int[] freqArr = new int[1000_000];
        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]+1000]++;
        }

        List<Integer>[] freqArrList = new ArrayList[nums.length+1];

        for( int i = 0; i < freqArrList.length; i++ ){
            freqArrList[i] = new ArrayList<Integer>();
        }

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] > 0 ) freqArrList[freqArr[i]].add(i-1000);
        }

        int r = 0;

        for( int i = freqArrList.length-1; i >= 0; i-- ){
            int j = 0;
            while( r < k && j < freqArrList[i].size() ){
                kFreqElements[r] = (int) freqArrList[i].get(j);
                r++;
                j++;
            }
        }

        return kFreqElements;
    }


    public int[] topKFrequent3(int[] nums, int k) {
        int[] kFreqElements = new int[k];
        Map<Integer, Integer> freqArr = new HashMap<>();
        for( int i = 0; i < nums.length; i++ ){
            if( !freqArr.containsKey(nums[i]) )
                freqArr.put(nums[i], 0);

            freqArr.put(nums[i], freqArr.get(nums[i])+1);
        }

        List<Integer>[] freqArrList = new ArrayList[nums.length+1];

        for( int i = 0; i < freqArrList.length; i++ ){
            freqArrList[i] = new ArrayList<Integer>();
        }

        for( int key: freqArr.keySet() ){
            if( freqArr.get(key) > 0 ) freqArrList[freqArr.get(key)].add(key);
        }

        int r = 0;

        for( int i = freqArrList.length-1; i >= 0; i-- ){
            int j = 0;
            while( r < k && j < freqArrList[i].size() ){
                kFreqElements[r] = freqArrList[i].get(j);
                r++;
                j++;
            }
        }

        return kFreqElements;
    }


}
