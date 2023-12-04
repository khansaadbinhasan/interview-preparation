package leetcode.easy;

//2
//4
//1
//10000
//999
//87
//65
//3
public class L1953ThreeDivisors {

    public boolean isThree(int n) {

        int divs = 0;

        for( int i = 1; i <= n; i++ ){

            if( n % i == 0 ) divs++;

            if( divs > 3 ) return false;

        }

        return divs == 3;

    }
}
