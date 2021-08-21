package hashing;

import java.util.*;

//14 3
//4 1 4 2 3 2 3 2 1 2 3 8 9 2
public class TopKfreqElement {

    public static void main(String[] args) {
        new TopKfreqElement().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] ans = topKFrequent(nums, K);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
    }

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

}
