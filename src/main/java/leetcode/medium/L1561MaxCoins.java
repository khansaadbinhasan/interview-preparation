package leetcode.medium;

import java.util.*;

//[2,4,1,2,7,8]
//[2,4,5]
//[9,8,7,6,5,1,2,3,4]
//[9,8,7,6,5,1,2111,3,4,9888,8,7,6,5999,1211,2,1000,4,9,8,1000,6,5,1,2111,3,4000,9,8,7,6000,5,1,2,3,4]
public class L1561MaxCoins {

    public int maxCoins(int[] piles) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < piles.length; i++ ){
            maxHeap.add(piles[i]);
        }

        int k = 0;
        int sum = 0;

        while( k < piles.length ){
            maxHeap.poll();
            sum += maxHeap.poll();

            k += 3;
        }

        return sum;
    }


}
