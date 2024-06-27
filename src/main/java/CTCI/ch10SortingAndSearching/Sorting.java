package CTCI.ch10SortingAndSearching;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        new Sorting().run();
    }

    public void run(){
        System.out.println("Merge sort: " + Arrays.toString(mergeSort(new int[]{1, 4, 5, 3})));
        System.out.println("Merge sort: " + Arrays.toString(mergeSort(new int[]{1,4,5,7,3,2,9})));
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,4,5,3));
        System.out.println(quickSort(list));
        list.addAll(Arrays.asList(1,4,5,3,7,2,9));
        System.out.println(quickSort(list));
    }


    //Sorts the array → [1,4,5,7,3,2,9] → 7
    //Sorts the array → [1,4,5,3] → 4
    public int[] mergeSort(int[] nums){//[4,5]
        if( nums.length == 1 ) return nums;

        int mid = nums.length/2;//1
        int[] nums1 = mergeSort(Arrays.copyOfRange(nums, 0, mid));//[1,4,5]
        int[] nums2 = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));//[3]

        return merge(nums1, nums2);
    }


    public int[] merge(int[] nums1, int[] nums2){//[1],[4,5]

        int[] nums = new int[nums1.length + nums2.length];//[1,4,5]

        int p1 = 0;//1
        int p2 = 0;//2
        int p = 0;//3

        while( p1 < nums1.length && p2 < nums2.length ){
            if( nums1[p1] <= nums2[p2] ){
                nums[p] = nums1[p1];
                p1++;
            }

            else{
                nums[p] = nums2[p2];
                p2++;
            }

            p++;
        }

        while( p1 < nums1.length ){
            nums[p] = nums1[p1];
            p++;
            p1++;
        }

        while( p2 < nums2.length ){
            nums[p] = nums2[p2];
            p++;
            p2++;
        }
        return nums;
    }

    public ArrayList<Integer> quickSort(ArrayList<Integer> nums){
        if( nums.size() < 2 ) return nums;

        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        int pivot = nums.get(0);

        for( int i = 1; i < nums.size(); i++ ){
            if( nums.get(i) < pivot ) nums1.add(nums.get(i));
            else nums2.add(nums.get(i));
        }

        nums = new ArrayList<>();
        nums1 = quickSort(nums1);
        nums2 = quickSort(nums2);
        nums.addAll(nums1);
        nums.add(pivot);
        nums.addAll(nums2);

        return nums;
    }



}
