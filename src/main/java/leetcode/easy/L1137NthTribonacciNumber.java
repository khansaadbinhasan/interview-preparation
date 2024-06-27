package leetcode.easy;

import java.util.Arrays;

public class L1137NthTribonacciNumber {
    int[] trib;

    public int tribonacci(int n) {
        trib = new int[n+1];
        Arrays.fill(trib, -1);

        return tribonacci(n, trib);
    }

    public int tribonacci(int n, int[] trib){
        if( n == 0 ) return 0;
        if( n == 1 || n == 2 ) return 1;
        if( trib[n] != -1 ) return trib[n];

        return trib[n] = (tribonacci(n-1, trib)+tribonacci(n-2, trib)+tribonacci(n-3, trib));
    }
}
