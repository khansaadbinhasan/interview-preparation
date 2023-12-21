package leetcode.easy;

import java.util.*;

//[1,2,3,1]
//[1,2,3,4]
//[1,1,1,3,3,4,3,2,4,2]
public class L217ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            int currLen = set.size();
            set.add(nums[i]);

            if( currLen == set.size() ) return true;
        }

        return false;
    }

}
