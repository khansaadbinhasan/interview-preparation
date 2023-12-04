package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

//[-2,-1,-1,1,2,3]
//[-3,-2,-1,0,0,1,2]
//[5,20,66,1314]
//[1]
//[0]
//[-1]
//[-1,1]
public class L2529MaxCountOfPositiveAndNegative {

    public int maximumCount(int[] nums) {

        int posCount = 0;
        int negCount = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] > 0 ) posCount++;
            else if( nums[i] < 0 ) negCount++;
        }

        return Math.max(posCount, negCount);

    }

}
