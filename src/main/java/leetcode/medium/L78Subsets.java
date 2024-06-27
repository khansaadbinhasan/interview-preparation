package leetcode.medium;

import java.util.*;

//[1,2,3]
//[0]
public class L78Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> powerSet = new LinkedList<>();

        //[1,2,3] --> 8
        //[], [1], [2], [3], [1,2], [2,3], [1,3], [1,2,3]
        powerSet.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> currPowerSet = new LinkedList<>();

            for( List<Integer> set: powerSet ){
                List<Integer> set1 = new LinkedList<>(set);
                List<Integer> set2 = new LinkedList<>(set);
                currPowerSet.add(set1);
                set2.add(nums[i]);
                currPowerSet.add(set2);
            }

            powerSet = currPowerSet;
        }

        return powerSet;
    }

    List<List<Integer>> subsets = new LinkedList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        subsets(nums, 0, new LinkedList<>());
        return subsets;
    }

    public void subsets(int[] nums, int i, List<Integer> lst){
        if( i == nums.length ) {
            subsets.add(lst);
            return;
        }

        List<Integer> lst1 = new LinkedList<>(lst);
        List<Integer> lst2 = new LinkedList<>(lst);
        subsets(nums, i+1, lst1);
        lst2.add(nums[i]);
        subsets(nums, i+1, lst2);
    }
}
