package leetcode.medium;

import java.util.*;

//[1,13,10,12,31]
//[2,2,2]
//[1,2,3]
//[1]
//[10000,999,1919,3333,121,12,999,990]
public class L2442CountNumberOfDistinctOperations {

    public int countDistinctIntegers(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }

        return set.size();
    }

    public int reverse(int num){
        int reverse = 0;

        while( num != 0 ){
            reverse = reverse*10 + num%10;
            num = num/10;
        }

        return reverse;
    }


}
