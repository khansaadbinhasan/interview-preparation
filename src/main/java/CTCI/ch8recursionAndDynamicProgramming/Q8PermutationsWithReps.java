package CTCI.ch8recursionAndDynamicProgramming;

import java.util.*;

public class Q8PermutationsWithReps {



    public List<List<Integer>> perms(List<Integer> nums){
        HashSet<List<Integer>> permute = new HashSet<>();
//        if( nums.size() == 0 ) return new LinkedList<>();
        if( nums.size() == 1 ) {
            List<List<Integer>> lists = new LinkedList<>();
            lists.add(new LinkedList<>(nums));
            return lists;
        }

        List<List<Integer>> perms = new LinkedList<>();

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.remove(0);

            perms = new LinkedList<>(perms(nums));

            for( List<Integer> perm: perms ) {
                perm.add(n);
            }

            permute.addAll(perms);
            nums.add(n);
        }

        return new LinkedList<>(permute);
    }

    public static void main(String[] args) {
        new Q8PermutationsWithReps().run();
    }

    public void run(){
        List<Integer> nums = new LinkedList<>();

        nums.add(1); nums.add(2); nums.add(1);

        System.out.println(perms(nums));
    }
}


//1,2,3
//1, perm(2,3)
//1, 2, 3
//1, 3, 2
//[[]]
//[[1]]
//perm(nums) --> nums[i] + perm(nums[i+1:])