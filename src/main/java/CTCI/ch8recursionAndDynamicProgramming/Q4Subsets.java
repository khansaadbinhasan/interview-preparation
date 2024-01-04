package CTCI.ch8recursionAndDynamicProgramming;

import java.util.*;

public class Q4Subsets {

    public static void main(String[] args) {
        new Q4Subsets().run();
    }

    public void run(){
        System.out.println(findSubsetsWithoutRepetition(new int[]{1,2,3}));
        System.out.println(findSubsetsWithoutRepetition(new int[]{}));
        System.out.println(findSubsetsWithoutRepetition(new int[]{0}));

        System.out.println(findSubsetsWithRepetition(new int[]{1,2,2,3}));
        System.out.println(findSubsetsWithRepetition(new int[]{1,1}));
        System.out.println(findSubsetsWithRepetition(new int[]{0,1,1}));
    }

    public List<List<Integer>> findSubsetsWithoutRepetition(int[] nums){
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


    public List<List<Integer>> findSubsetsWithRepetition(int[] nums){
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
