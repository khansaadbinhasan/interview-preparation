package leetcode.easy;

import java.util.*;

//[1,2,2,1,1,3]
//[1,2]
//[-3,0,1,-3,1,1,1,-3,10,0]
public class L1207UniqueOccurences {

    public boolean uniqueOccurrences(int[] arr) {

        int[] freqArr = new int[2001];

        for( int i = 0; i < arr.length; i++ ){
            freqArr[arr[i]+1000]++;
        }

        Set<Integer> s = new HashSet<>();

        for( int i = 0; i < freqArr.length; i++ ){
            if( s.contains(freqArr[i])) return false;
            if( freqArr[i] != 0 ) s.add(freqArr[i]);
        }

        return true;
    }

}
