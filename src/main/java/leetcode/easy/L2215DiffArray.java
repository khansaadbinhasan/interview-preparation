package leetcode.easy;

import java.util.*;

//[1,2,3]
//[2,4,6]
//[1,2,3,3]
//[1,1,2,2]
public class L2215DiffArray {

    public static void main(String[] args){
        new L2215DiffArray().run();
    }

    public void run(){
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        for( int i = 0; i < nums1.length; i++ ){
            if( !isPresent(nums2, nums1[i]) && !list1.contains(nums1[i]) ) list1.add(nums1[i]);
        }

        for( int i = 0; i < nums2.length; i++ ){
            if( !isPresent(nums1, nums2[i]) && !list2.contains(nums2[i]) ) list2.add(nums2[i]);
        }

        List<List<Integer>> numsList = new LinkedList<>();

        numsList.add(list1);
        numsList.add(list2);

        return numsList;
    }

    public boolean isPresent( int[] nums, int val ){
        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == val ) return true;
        }

        return false;
    }
}
