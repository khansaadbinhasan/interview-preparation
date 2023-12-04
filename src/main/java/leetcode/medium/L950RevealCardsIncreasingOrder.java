package leetcode.medium;

import java.util.*;

//[17,13,11,2,3,5,7]
//[1,1000]
//[1]
//[1,2,3,4,5,6,7]
//[100,82,23,121,1000,4,3,2,1,11,12,13,41,51,61,91,21,71,15,19,17,101,111]
public class L950RevealCardsIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q = new LinkedList<>();

        for( int i = 0; i < deck.length; i++ ){
            maxHeap.add(deck[i]);
        }

        q.add(maxHeap.poll());

        while( q.size() != deck.length && !maxHeap.isEmpty() ){
            int last = q.poll();
            q.add(last);
            q.add(maxHeap.poll());
        }

        int[] revealed = new int[q.size()];

        for( int i = q.size()-1; i >= 0; i-- ){
            revealed[i] = q.poll();
        }

        return revealed;
    }


}
