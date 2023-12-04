package leetcode.easy;

import java.util.*;

//10
//0
//1
//7
//6
//60
//500
//678
//897
//5000000

public class L204CountPrimes {

    public int countPrimes(int n) {
        if( n <= 2 ) return 0;

        boolean[] isPrime = new boolean[n];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        int count = 0;

        for( int i = 2; i < n; i++ ){
            if( isPrime[i] ){
                count++;

                for( int j = 2; i*j < n; j++ ){
                    isPrime[i*j] = false;
                }
            }
        }

        return count;
    }

}
