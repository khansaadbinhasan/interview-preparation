package leetcode.easy;

import java.util.*;

//[1,1,4,2,1,3]
//[5,1,2,3,4]
//[1,2,3,4,5]
//[1]
//[100]
//[5,4,3,2]
public class L1051HeightChecker {

    public int heightChecker(int[] heights) {

        int[] sortedHeight = heights.clone();

        Arrays.sort(sortedHeight);

        int count = 0;

        for( int i = 0; i < heights.length; i++ ){
            if( heights[i] != sortedHeight[i] ) count++;
        }

        return count;
    }

}
