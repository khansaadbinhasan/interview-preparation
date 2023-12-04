package leetcode.easy;

import java.util.*;

//5
//2
//4
//4
//3
//3
//5
//1
//1
//1
//4
//2
//50
//50
//3
//2
public class L2682FindLosersOfCircularGame {

    public static void main(String[] args) {
        new L2682FindLosersOfCircularGame().run();
    }

    public void run(){
        int[] losers = circularGameLosers(3, 2);

        System.out.println(Arrays.toString(losers));
    }

    public int[] circularGameLosers(int n, int k) {

        Set<Integer> winners = new HashSet<>();

        int i = 1;
        int counter = 2;
        int initK = k;

        while( !winners.contains(i) ){
            winners.add(i);

            i = (i+k) % n;
            k = counter * initK;
            counter++;

            if( i == 0 ) i = n;
        }

        if( winners.size() >= n ) return new int[]{};

        int[] losers = new int[n-winners.size()];
        counter = 0;

        for( i = 1; i <= n; i++ ){
            if( !winners.contains(i) ) losers[counter++]=i;
        }

        return losers;
    }
}
