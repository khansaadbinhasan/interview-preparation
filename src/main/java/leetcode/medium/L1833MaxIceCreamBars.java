package leetcode.medium;

import java.util.*;

public class L1833MaxIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for( int i = 0; i < costs.length; i++ ){
            minHeap.add(costs[i]);
        }

        int max = 0;

        while( !minHeap.isEmpty() ){
            if( minHeap.peek() > coins ) {
                break;
            }
            coins -= minHeap.poll();
            max++;
        }

        return max;
    }

}
