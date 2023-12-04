package leetcode.easy;

import java.util.*;

//[1,1,3,2]
//[2,3]
//[3]
//[3,1]
//[2,3]
//[1,2]
//[1,2,2]
//[4,3,3]
//[5]
//[1]
//[1]
//[1]
public class L2032TwoOutOfThree {

    public static void main(String[] args) {
        new L2032TwoOutOfThree().run();
    }

    public void run(){
        System.out.println(twoOutOfThree(new int[]{1,2}, new int[]{2,3}, new int[]{1,3}));
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> intersection1 = intersection(nums1, nums2);
        Set<Integer> intersection2 = intersection(nums1, nums3);
        Set<Integer> intersection3 = intersection(nums2, nums3);

        List<Integer> nums = new LinkedList<>(
                union(
                        new LinkedList<>(intersection1), new LinkedList<>(intersection2)
                )
        );

        return new LinkedList<>(
                union(
                        nums,
                        new LinkedList<>(intersection3)
                )
        );
    }

    Set<Integer> intersection(int[] nums1, int[] nums2){
        Set<Integer> intersectionSet = new HashSet<>();

        for( int i = 0; i < nums1.length; i++ ){
            for( int j = 0; j < nums2.length; j++ ){
                if( nums1[i] == nums2[j] ){
                    intersectionSet.add(nums1[i]);
                }
            }
        }

        return intersectionSet;
    }

    Set<Integer> union(List<Integer> nums1, List<Integer> nums2){
        Set<Integer> unionSet = new HashSet<>();

        unionSet.addAll(nums1);
        unionSet.addAll(nums2);

        return unionSet;
    }

}
