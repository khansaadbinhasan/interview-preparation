package leetcode.easy;

//12
//6
//25
//30
public class L2427NumberOfCommonFactors {

    public int commonFactors(int a, int b) {

        int commonFactors = 0;

        int num = a < b ? a: b;

        for( int i = 1; i <= num; i++ ){
            if( a % i == 0 && b % i == 0 ) commonFactors++;
        }

        return commonFactors;

    }
}
