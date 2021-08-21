package arrays;

import java.util.Scanner;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        new MedianOfSortedArrays().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] nums1 = new int[M];
        int[] nums2 = new int[N];

        for (int i = 0; i < M; i++) nums1[i] = sc.nextInt();
        for (int i = 0; i < N; i++) nums2[i] = sc.nextInt();

        System.out.println((int) findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] numsSmaller = nums1.length <= nums2.length ? nums1 : nums2;
        int[] numsLarger = nums1.length > nums2.length ? nums1 : nums2;

        int totalElems = numsSmaller.length + numsLarger.length;

        int start = 0;
        int end = numsSmaller.length;

        while (start <= end) {

            int mid = (start + end) / 2;
            int partitionInLargerArr = (totalElems+1) / 2 - mid;

            if (mid > 0 && numsSmaller[mid - 1] > numsLarger[partitionInLargerArr]) end = mid - 1;
            else if (mid < end && numsSmaller[mid] < numsLarger[partitionInLargerArr - 1]) start = mid + 1;

            else {

                int zMid = 0;

                if (mid == 0) zMid = numsLarger[partitionInLargerArr - 1];
                else if (partitionInLargerArr == 0) zMid = numsSmaller[mid - 1];
                else zMid = Math.max(numsSmaller[mid - 1], numsLarger[partitionInLargerArr - 1]);

                if( totalElems % 2 == 1 ) return zMid;

                int zMidPlus1 = 0;

                if (mid == numsSmaller.length) zMidPlus1 = numsLarger[partitionInLargerArr];
                else if (partitionInLargerArr == numsLarger.length) zMidPlus1 = numsSmaller[mid];
                else zMidPlus1 = Math.min(numsSmaller[mid], numsLarger[partitionInLargerArr]);

                if( totalElems % 2 == 0 ) return (zMid + zMidPlus1) / 2.0;
            }
        }

        return 0;
    }
}
