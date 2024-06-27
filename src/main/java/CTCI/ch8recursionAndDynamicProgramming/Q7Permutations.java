package CTCI.ch8recursionAndDynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class Q7Permutations {

//    public List<List<Integer>> permutationsWithoutDups(int[] nums){
//
//        List<List<Integer>> perms = new LinkedList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> lst = new LinkedList<>();
//            lst.add(nums[i]);
//            perms.add(lst);
//        }
//
//        for (List<Integer> p: perms) {
//            for (int j = 0; j < nums.length; j++) {
////                if( i != j )
//            }
//        }
//
//        return perms;
//    }
//
    public List<List<Integer>> perms(List<Integer> nums){
        List<List<Integer>> permute = new LinkedList<>();
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

        return permute;
    }

    public static void main(String[] args) {
        new Q7Permutations().run();
    }

    public void run(){
        List<Integer> lst = new LinkedList<>();
        lst.add(1);lst.add(2);lst.add(3);
        System.out.println(perms(lst));

//        // Create an array
//        Integer[] array = {1,2,3};
//
//        // Convert array to list using ArrayList
//        List<Integer> listFromArray = new ArrayList<>(Arrays.asList(array));
//
//        // Print the elements in the list
//        System.out.println("List from array: " + listFromArray);
    }
}


//1,2,3
//1, perm(2,3)
//1, 2, 3
//1, 3, 2
//[[]]
//[[1]]
//perm(nums) --> nums[i] + perm(nums[i+1:])