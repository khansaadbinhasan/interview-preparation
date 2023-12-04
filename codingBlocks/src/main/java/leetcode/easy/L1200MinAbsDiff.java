package leetcode.easy;

import java.util.*;

//[4,2,1,3]
//[1,3,6,10,15]
//[3,8,-10,23,19,-4,-14,27]
public class L1200MinAbsDiff {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for( int i = 0; i < arr.length-1; i++ ){
            minDiff = Math.min(minDiff, Math.abs(arr[i]-arr[i+1]));
        }

        List<List<Integer>> lst = new LinkedList<>();

        for( int i = 0; i < arr.length-1; i++ ){
            if( Math.abs(arr[i]-arr[i+1]) == minDiff )
                lst.add(Arrays.asList(arr[i], arr[i+1]));
        }

        return lst;
    }

}
