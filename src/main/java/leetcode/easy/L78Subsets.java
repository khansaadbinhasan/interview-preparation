package leetcode.easy;

import java.util.*;

public class L78Subsets {

    public static void main(String[] args) {
        List<List<Integer>> subsets = new L78Subsets().subsets(new int[]{1, 2, 3});

        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsetList = new LinkedList<>();

        for( int i = 0; i < Math.pow(2, nums.length); i++ ){
            String binRep = Integer.toBinaryString(i);
            List<Integer> setList = new LinkedList<>();

            while( binRep.length() < nums.length ) {
                binRep = "0" + binRep;
            }

            int bin = i;

            for( int j = binRep.length()-1; j >= 0; j-- ){
                if( (bin & 1) == 1 ){
                    setList.add(nums[j]);
                }
                bin = bin >>> 1;
            }

            subsetList.add(setList);
        }

        return subsetList;
    }

    public List<List<Integer>> subsetsNoReps(int[] nums) {

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

}
