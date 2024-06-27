package leetcode.medium;

import java.util.*;

//[1,2,3,6,2,3,4,7,8]
//3
//[1,2,3,4,5]
//4
//[1,1,1,1,1]
//1
//[1,1,1,1,1]
//2
//[1,2,3,4,5]
//3
//[1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5,1,3,4,5,2,6,7,8,2,3,4,5,6,1,3,7,5]
//3
//[1,1,2,2,3,3]
//3
public class L846HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i < hand.length; i++ ){
            minHeap.add(hand[i]);
            map.putIfAbsent(hand[i], 0);
            map.put(hand[i], map.get(hand[i])+1);
        }

        while( !minHeap.isEmpty() ){
            int key = minHeap.peek();
            for( int i = 0; i < groupSize; i++ ){
                if( map.containsKey(key) && map.get(key) > 0 ){
                    map.put(key, map.get(key)-1);
                    minHeap.remove(key);
                }
                else return false;

                key++;
            }
        }

        return true;
    }
}
