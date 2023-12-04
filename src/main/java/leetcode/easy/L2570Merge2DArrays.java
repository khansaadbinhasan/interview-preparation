package leetcode.easy;

import java.util.*;

//[[1,2],[2,3],[4,5]]
//[[1,4],[3,2],[4,1]]
//[[2,4],[3,6],[5,5]]
//[[1,3],[4,3]]
//[[1,1],[2,2]]
//[[1,1],[2,2]]
//[[1,1]]
//[[1,1]]
public class L2570Merge2DArrays {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums1.length; i++ ){
            set.add(nums1[i][0]);
        }

        for( int i = 0; i < nums2.length; i++ ){
            set.add(nums2[i][0]);
        }

        int[][] nums = new int[set.size()][2];

        int i = 0;
        int j = 0;
        int k = 0;

        while( i < nums.length && j < nums1.length &&  k < nums2.length ){
            if( nums1[j][0] < nums2[k][0] ){
                nums[i] = nums1[j];
                j++;
            }

            else if( nums1[j][0] > nums2[k][0] ){
                nums[i] = nums2[k];
                k++;
            }

            else {
                nums[i][0] = nums1[j][0];
                nums[i][1] = nums1[j][1] + nums2[k][1];

                j++;
                k++;
            }

            i++;
        }

        while( i < nums.length && j < nums1.length ){
            nums[i] = nums1[j];
            j++;
            i++;
        }

        while( i < nums.length && k < nums2.length ){
            nums[i] = nums2[k];
            k++;
            i++;
        }

        return nums;

    }
}
