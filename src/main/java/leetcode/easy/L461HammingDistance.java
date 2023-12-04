package leetcode.easy;

//1
//4
//3
//1
//0
//0
//0
//1
//100
//2147483647
//0
//2147483647
//1
//2147483647
public class L461HammingDistance {

    public int hammingDistance(int x, int y) {
        int numBitsOr = numBits(x|y);
        int numBitsAnd = numBits(x&y);

        return numBitsOr - numBitsAnd;
    }

    public int numBits(int n){

        int count = 0;

        while( n > 0 ){
            if( (n & 1) == 1 ) count++;
            n = n >> 1;
        }

        return count;
    }

}
