package leetcode.easy;

import java.util.*;

//[3,2,1]
//[1,2]
//[2,2,3,1]
//[2,2,3,1]
//[2,2,3,1,2147483647,-2147483647,2147483641,2147483642]
//[-2147483647,-2147483647,-2147483641,-2147483642]
//[1]
public class L414ThirdMaxNumber {

    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            if( !set.contains(nums[i]) ) {
                pq.add(nums[i]);
                set.add(nums[i]);
            }
        }

        if( pq.size() < 3 ) return pq.poll();

        pq.poll();
        pq.poll();

        return pq.poll();
    }
}
