package leetcode.easy;

//2
//11
//10000
//100
//9999
//7
//19
//2833
public class L1317ConvertIntegerToNoZeroSum {

    public int[] getNoZeroIntegers(int n) {
        for( int i = 1; i <= n/2; i++ ){
            if( isNoZeroInteger(i) && isNoZeroInteger(n-i) ) return new int[]{i, n-i};
        }

        return new int[]{1, n-1};
    }

    public boolean isNoZeroInteger(int n){
        while( n != 0 ){
            if( n % 10 == 0 ) return false;
            n = n / 10;
        }

        return true;
    }
}
