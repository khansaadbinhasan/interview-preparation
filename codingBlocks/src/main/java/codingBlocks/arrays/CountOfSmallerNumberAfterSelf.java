package codingBlocks.arrays;

import java.util.*;

public class CountOfSmallerNumberAfterSelf {

    static class Pair{
        int idx;
        int data;

        Pair( int idx, int data ){
            this.idx = idx;
            this.data = data;
        }
    }

    static int[] ans;

    public static void main(String[] args) {
        new CountOfSmallerNumberAfterSelf().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Pair[] pairs = new Pair[N];
        ans = new int[N];

        for (int i = 0; i < N; i++)
            pairs[i] = new Pair(i, sc.nextInt());

        mergeSort(pairs, 0, pairs.length-1);

        for(int i: ans)
            System.out.println(i + " ");

        System.out.println();
    }

    public void mergeSort(Pair[] pairs, int start, int end){
        if( start < end ){
            int mid = (end+start) / 2;

            mergeSort(pairs, start, mid);
            mergeSort(pairs, mid + 1, end);

            merge(pairs, start, mid, end);
        }
    }

    public void merge(Pair[] pairs, int start, int mid, int end){

        Pair[] nums1 = new Pair[mid-start+1];
        Pair[] nums2 = new Pair[end-mid];

        for (int i = start; i <= mid; i++)
            nums1[i-start] = pairs[i];

        for (int i = mid+1; i <= end; i++)
            nums2[i-mid-1] = pairs[i];

        int nums1Pointer = 0;
        int nums2Pointer = 0;
        int i = start;
        int count = 0;

        while( nums1Pointer < nums1.length && nums2Pointer < nums2.length ) {
            if( nums1[nums1Pointer].data <= nums2[nums2Pointer].data ) {
                ans[nums1[nums1Pointer].idx] += count;
                pairs[i] = nums1[nums1Pointer];
                nums1Pointer++;
            }

            else {
                count++;
                pairs[i] = nums2[nums2Pointer];
                nums2Pointer++;
            }

            i++;
        }

        while (nums1Pointer < nums1.length) {
            ans[nums1[nums1Pointer].idx] += count;
            pairs[i] = nums1[nums1Pointer];
            nums1Pointer++;
            i++;
        }

        while (nums2Pointer < nums2.length) {
            pairs[i] = nums2[nums2Pointer];
            nums2Pointer++;
            i++;
        }
    }
}