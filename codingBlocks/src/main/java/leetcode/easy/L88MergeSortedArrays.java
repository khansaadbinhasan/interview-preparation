package leetcode.easy;

import java.util.Arrays;

public class L88MergeSortedArrays {

    public static void main(String[] args) {
        new L88MergeSortedArrays().run();
    }

    public void run(){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;

        int[] nums2 = new int[]{2,3,5};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums = new int[m+n];

        int pointer1 = 0;
        int pointer2 = 0;
        int index = 0;

        while( pointer1 < m && pointer2 < n ){
            if( nums1[pointer1] < nums2[pointer2] ){
                nums[index] = nums1[pointer1];
                pointer1++;
            }

            else {
                nums[index] = nums2[pointer2];
                pointer2++;
            }

            index++;
        }

        while( pointer1 < m ){
            nums[index] = nums1[pointer1];
            pointer1++;
            index++;
        }

        while( pointer2 < n ){
            nums[index] = nums2[pointer2];
            pointer2++;
            index++;
        }

        nums1 = nums;

//        for (int i = 0; i < m + n; i++) {
//            nums1[i] = nums[i];
//        }

    }


}
