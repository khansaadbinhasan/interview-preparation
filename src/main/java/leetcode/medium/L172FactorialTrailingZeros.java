package leetcode.medium;

public class L172FactorialTrailingZeros {

    public int trailingZeroes(int N) {
        int count5 = 0;

        for (int i = 0; i <= N; i+=5) {
            count5 += getNCount(i, 5);
        }

        return count5;
    }


    public int getNCount(int num, int N){
        int Ncount = 0;

        while( num > 0 ){
            if( num % N != 0 ){
                break;
            }

            Ncount++;
            num = num / N;
        }

        return Ncount;
    }

    //5 --> 1
    //10 --> 2
    //15 --> 3
    public int trailingZeroes2(int n) {
        int zeros = 0;
        for( int i = 5; i <= n; i*=5 ){
            zeros += n/i;
        }

        return zeros;
    }

}
