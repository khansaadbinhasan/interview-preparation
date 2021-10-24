package leetcode.easy;

import java.util.*;

//[1,2,2,1]
//[2,2]
//[4,9,5]
//[9,4,9,8,4]
public class L349IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        int[] freqArr1 = new int[1001];
        int[] freqArr2 = new int[1001];

        for( int i = 0; i < nums1.length; i++ ){
            freqArr1[nums1[i]]++;
        }

        for( int i = 0; i < nums2.length; i++ ){
            freqArr2[nums2[i]]++;
        }

        List<Integer> lst = new LinkedList<>();

        for( int i = 0; i < freqArr1.length; i++ ){
            if( freqArr1[i] > 0 && freqArr2[i] > 0 ) lst.add(i);
        }

        return lst.stream().mapToInt(i->i).toArray();

    }

}
