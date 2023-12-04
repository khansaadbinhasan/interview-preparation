package leetcode.medium;

import java.util.*;

//[1,2,2]
//[0]
//[4,4,4,1,4]
//[1,1,1,1,1]
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

}
