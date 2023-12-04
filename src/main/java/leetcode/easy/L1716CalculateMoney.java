package leetcode.easy;

//4
//10
//20
public class L1716CalculateMoney {

    public int totalMoney(int n) {

        int total = 0;

        int counter = 0;

        for( int i = 1; i <= n; i+=7 ){

            total += ++counter;

            int starting = counter;

            int r = 7;

            if( n < i+7 ) r = n-i+1;

            for( int j = 2; j <= r; j++ ){
                total += ++starting;
            }
        }

        return total;
    }

}
