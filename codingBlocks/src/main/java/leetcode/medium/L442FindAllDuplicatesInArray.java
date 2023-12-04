package leetcode.medium;

import java.util.*;

//[4,3,2,7,8,2,3,1]
//[1,1,2]
//[1]
public class L442FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        int[] freqArr = new int[nums.length+1];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]]++;
        }

        List<Integer> lst = new LinkedList<>();

        for( int i = 1; i < freqArr.length; i++ ){
            if( freqArr[i] == 2 ) lst.add(i);
        }

        return lst;
    }

}
