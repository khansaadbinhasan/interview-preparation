package codingBlocks.hashing;

import java.util.*;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        new SubArraySumEqualsK().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(subarraySum(nums, k));
    }


    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        int subArrCount = 0;
        int sum = 0;

        freqMap.put(0,1);

        for (int num : nums) {
            sum += num;

            if (freqMap.containsKey(sum - k)) subArrCount += freqMap.get(sum - k);

            if (freqMap.containsKey(sum)) freqMap.put(sum, freqMap.get(sum) + 1);
            else freqMap.put(sum, 1);
        }

        return subArrCount;
    }


    public int subarraySumUghh(int[] nums, int k) {

        int subArrCount = 0;

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        Map<Integer, List<Integer>> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if( !freqMap.containsKey(nums[i]) ) freqMap.put(nums[i], new LinkedList<>());

            freqMap.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int numToSearch = k + nums[i];

            if( k == nums[i] ) subArrCount++;

            if( freqMap.containsKey(numToSearch) ){
                for( int ind: freqMap.get(numToSearch) ){
                    if( ind > i ) subArrCount++;
                }
            }
        }

        return subArrCount;
    }


    public int subarraySumBF(int[] nums, int k) {

        int subArrCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];

            if( sum == k ) subArrCount++;

            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];

                if( sum == k ) subArrCount++;
            }
        }

        return subArrCount;
    }

}
