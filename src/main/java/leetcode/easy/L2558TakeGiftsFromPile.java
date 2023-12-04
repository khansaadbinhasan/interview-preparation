package leetcode.easy;

import java.util.*;


//[25,64,9,4,100]
//4
//[1,1,1,1]
//4
//[10]
//1
//[1999,2449,24232]
//1
public class L2558TakeGiftsFromPile {

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> giftPile = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < gifts.length; i++ ){
            giftPile.add(gifts[i]);
        }

        while( !giftPile.isEmpty() && k > 0 ){
            int gift = giftPile.poll();
            giftPile.add((int) Math.sqrt(gift));
            k--;
        }

        long sum = 0;

        while( !giftPile.isEmpty() ){
            int gift = giftPile.poll();
            sum += gift;
        }

        return sum;

    }
}
