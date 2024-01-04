package leetcode.medium;

import java.util.*;

//[1,2,3]
//[0,1]
//[1]
public class L46Permutations {


    public static void main(String[] args) {
        new L46Permutations().run();
    }

    public void run(){
        LinkedList<Integer> nums = new LinkedList<>();

        nums.add(1); nums.add(2); nums.add(3);

        System.out.println(permute(nums));

        System.out.println(permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> lst = new LinkedList<>();

        for( int i = 0; i < nums.length; i++ ){
            lst.add(nums[i]);
        }

        return permute(lst);

    }

    List<List<Integer>> permute = new LinkedList<>();

    public List<List<Integer>> permute(List<Integer> nums){
        if( nums.size() == 0 ) return new LinkedList<>();
        if( nums.size() == 1 ) {
            List<List<Integer>> lst = new LinkedList<>();
            lst.add(new LinkedList<>(nums));
            return lst;
        }

        for( int i = 0; i < nums.size(); i++ ){
            int n = nums.remove(0);
            permute = new LinkedList<>(permute(nums));

            for( List<Integer> perm: permute ){
                perm.add(n);
            }

            nums.add(n);
        }

        return permute;
    }
}
