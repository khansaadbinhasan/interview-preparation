package DP;

import java.util.*;

//2
//9
//1 3 5 7 4 3 5 2 6
//11
//4 5 6 3 2 7 8 5 4 6 3

public class BitonicSubsequence {
    public static void main(String[] args) {
        new BitonicSubsequence().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        List<Integer> ansList = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }

            ansList.add(bitonicSubsequenceLen(nums));
        }

        ansList.forEach(val -> System.out.println(val));
    }

    public int bitonicSubsequenceLen(int[] nums){

        if( nums.length < 3 ) return 0;

        int maxLen = Integer.MIN_VALUE;

        int[] left = longestIncreasingSubsequence(nums);
        int[] right = longestDescreasingSubsequence(nums);

        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, left[i] + right[i] - 1);
        }

        return maxLen;
    }

    public int[] longestIncreasingSubsequence(int[] nums){

        int[] subSeq = new int[nums.length];

        Arrays.fill(subSeq, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if( nums[i] > nums[j] && subSeq[j] >= subSeq[i] ) subSeq[i] = subSeq[j] + 1;
            }
        }

        return subSeq;
    }

    public int[] longestDescreasingSubsequence(int[] nums){

        int[] subSeq = new int[nums.length];

        Arrays.fill(subSeq, 1);

        for (int i = nums.length-2; i >= 0; i--) {
            for (int j = nums.length-1; j > i; j--) {
                if( nums[i] > nums[j] && subSeq[j] >= subSeq[i] ) subSeq[i] = subSeq[j] + 1;
            }
        }

        return subSeq;
    }
}
