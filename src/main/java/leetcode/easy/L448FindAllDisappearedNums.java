package leetcode.easy;

import java.util.*;

public class L448FindAllDisappearedNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;


        int[] freqArr = new int[nums.length+1];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]]++;
        }

        List<Integer> lst = new LinkedList<>();

        for( int i = 1; i < freqArr.length; i++ ){
            if( freqArr[i] == 0 ) lst.add(i);
        }

        return lst;

    }

}
