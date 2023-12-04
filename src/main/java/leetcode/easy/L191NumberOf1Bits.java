package leetcode.easy;

//00000000000000000000000000001011
//00000000000000000000000010000000
//11111111111111111111111111111101
//00000000000000000000000000000000
//00000000000000000000000000000001
//10000000000000000000000000000000
//10101000000000010101111111111100

public class L191NumberOf1Bits {

    public int hammingWeight(int n) {

        int weight = 0;

        for( char c: Integer.toBinaryString(n).toCharArray() ){
            if( c == '1' ) weight++;
        }

        return weight;

    }

    public int hammingWeightBitwise(int n) {

        int weight = 0;

        while( n != 0 ){
            weight += n & 1;
            n = n >>> 1;//unsigned operator
        }

        return weight;

    }


}
