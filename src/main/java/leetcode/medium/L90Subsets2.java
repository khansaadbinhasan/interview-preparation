package leetcode.medium;

import java.util.*;

//[1,2,2]
//[0]
//[4,4,4,1,4]
//[1,1,1,1,1]
//[1,2,2]
//[0]
//[4,4,4,1,4]
//[1,1,1,1,1]
//[1,2,2,3]
//[1,1,1,2,2,2,3,3,3,3]
public class L90Subsets2 {

    public static void main(String[] args) {
        new L90Subsets2().run();
    }

    public void run(){


    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = subsets(nums, 0, new LinkedList<>(), new LinkedList<>());

        return new LinkedList<>(new HashSet<>(subsets));
    }

    public List<List<Integer>> subsets(int[] nums, int i, LinkedList<Integer> s, List<List<Integer>> subsets){

        LinkedList<Integer> currSubset = new LinkedList<>(s);

        if( i == nums.length ) {
            currSubset.sort(Comparator.naturalOrder());
            subsets.add(currSubset);
            return subsets;
        }

        currSubset.add(nums[i]);
        subsets = subsets(nums, i+1, currSubset, subsets);
        currSubset.removeLast();

        return subsets(nums, i+1, currSubset, subsets);
    }

    public List<List<Integer>> subsetsWithDuplicates(int[] nums){
        Set<List<Integer>> powerSet = new HashSet<>();

        //[1,2,2,3] --> 8
        //[], [1], [2], [3], [1,2], [2,3], [1,3], [1,2,3]
        powerSet.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> currPowerSet = new HashSet<>();

            for( List<Integer> set: powerSet ){
                List<Integer> set1 = new LinkedList<>(set);
                List<Integer> set2 = new LinkedList<>(set);
                set1.sort(Comparator.naturalOrder());
                currPowerSet.add(set1);
                set2.add(nums[i]);
                set2.sort(Comparator.naturalOrder());
                currPowerSet.add(set2);
            }

            powerSet = currPowerSet;
        }

        return new LinkedList<>(powerSet);
    }
}
