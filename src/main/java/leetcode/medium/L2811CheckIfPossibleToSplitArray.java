package leetcode.medium;

import java.util.*;

//[2, 2, 1]
//4
//[2, 1, 3]
//5
//[2, 3, 3, 2, 3]
//6
//[1]
//1
//[1]
//2
//[1,2,3,4,5,6,7,8,9]
//3
//[1,2,3,4,5,6,7,8,9]
//17
//[1,2,3,4,5,6,7,8,9]
//170
public class L2811CheckIfPossibleToSplitArray {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if( nums.size() <= 2 ) return true;
        for( int i = 1; i < nums.size(); i++ ){
            if( nums.get(i) + nums.get(i-1) >= m ) return true;
        }

        return false;
    }
}
