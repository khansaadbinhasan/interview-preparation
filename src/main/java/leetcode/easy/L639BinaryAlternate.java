package leetcode.easy;

//5
//7
//11
//1
//10
//111
//2147483647
//1234
public class L639BinaryAlternate {

    public boolean hasAlternatingBits(int n) {

        int bit0 = n & 1;
        n = n >>> 1;

        while( n != 0 ){
            if( bit0 == (n & 1) ) return false;

            bit0 = n & 1;
            n = n >>> 1;
        }

        return true;

    }
}
