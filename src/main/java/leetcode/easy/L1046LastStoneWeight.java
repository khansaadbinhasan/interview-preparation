package leetcode.easy;

import java.util.*;

//[2,7,4,1,8,1]
//[1]
//[7,5,3,2,2,4]
//[7,7,7,4,3,3,3,2]
//[7,7,7,7,7]
//[14,13,15,16,6,3,21,21,23,8,9,15]
//[100,1000]
public class L1046LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for( int i = 0; i < stones.length; i++ ){
            pq.offer(stones[i]);
        }

        while( !pq.isEmpty() && pq.size() > 1 ){

            int stone1 = pq.poll();
            int stone2 = pq.poll();

            pq.offer( stone1 - stone2 );
        }

        return pq.size() == 0? 0: pq.poll();
    }

}
