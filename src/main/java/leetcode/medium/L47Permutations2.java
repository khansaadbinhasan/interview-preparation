package leetcode.medium;

import java.util.*;

//[1,1,2]
//[1,2,3]
//[1]
//[1,1,1,1,1,1]
public class L47Permutations2 {


    public static void main(String[] args) {
        new L47Permutations2().run();
    }

    public void run(){
        LinkedList<Integer> nums = new LinkedList<>();

        nums.add(1); nums.add(2); nums.add(3);

        System.out.println(permute(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return new LinkedList<>(new HashSet<>(permute(nums)));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> lst = new LinkedList<>();

        for( int i = 0; i < nums.length; i++ ){
            lst.add(nums[i]);
        }

        return permute(lst);
    }

    public List<List<Integer>> permute(List<Integer> nums){
        List<List<Integer>> permute = new LinkedList<>();
        if( nums.size() == 1 ) {
            List<List<Integer>> lst = new LinkedList<>();
            lst.add(new LinkedList<>(nums));
            return lst;
        }

        for( int i = 0; i < nums.size(); i++ ){
            int n = nums.remove(0);
            List<List<Integer>> perms = new LinkedList<>(permute(nums));

            for( List<Integer> perm: perms ){
                perm.add(n);
            }

            permute.addAll(perms);
            nums.add(n);
        }

        return permute;
    }
}
