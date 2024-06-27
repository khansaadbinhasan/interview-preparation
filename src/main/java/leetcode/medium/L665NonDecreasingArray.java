package leetcode.medium;

import java.util.*;

//[4,2,3]
//[4,2,1]
//[1]
//[2,5,4,3,2,1,8,4]
//[1,2,3]
//[1,2,3,6,5,3,2,1,5,8,4,3]
//[3,2,1,9,7,4,1,-1,-9,-8,-7,-4]
//[5,4,3,6,7,8,1]
//[5,7,1,8]
//[2,3,3,2,4]
public class L665NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Integer> lst1 = new LinkedList<>();
        List<Integer> lst2 = new LinkedList<>();

        for( int i = 0; i < sorted.length; i++ ){
            lst1.add(sorted[i]);
        }

        for( int i = 0; i < nums.length; i++ ){
            lst2.add(nums[i]);
        }

        int p1 = 0;
        int p2 = 0;
        int diff = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] != sorted[i] ){
                List<Integer> l1 = new LinkedList<>(lst1);
                List<Integer> l2 = new LinkedList<>(lst2);
                l1.remove((Integer) nums[i]);
                l2.remove((Integer) nums[i]);

                lst1.remove((Integer) sorted[i]);
                lst2.remove((Integer) sorted[i]);

                return lst1.equals(lst2) || l1.equals(l2);
            }
            lst1.remove((Integer) nums[i]);
            lst2.remove((Integer) nums[i]);
        }

        return true;

    }

}
