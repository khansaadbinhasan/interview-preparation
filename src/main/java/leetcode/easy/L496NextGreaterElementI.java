package leetcode.easy;

import java.util.*;

//[4,1,2]
//[1,3,4,2]
//[2,4]
//[1,2,3,4]
//[0]
//[0]
public class L496NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i < nums2.length; i++ ){

            map.put(nums2[i], -1);

            for( int j = i+1; j < nums2.length; j++ ){
                if( nums2[j] > nums2[i] ){
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        int[] nums = new int[nums1.length];

        for( int i = 0; i < nums1.length; i++ ){
            nums[i] = map.get(nums1[i]);
        }

        return nums;
    }

}
