package leetcode.easy;

public class L326PowerOf3 {

    public boolean isPowerOfThree(int n) {

        if( n <= 0 ) return false;

        boolean isPower = false;

        while( !isPower ){

            if( n == 1 ) return true;
            if( n % 3 != 0 ) return false;

            n = n / 3;
        }

        return false;

    }

}
