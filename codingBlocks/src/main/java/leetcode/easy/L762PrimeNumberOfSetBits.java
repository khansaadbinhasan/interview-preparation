package leetcode.easy;

//6
//10
//10
//15
//1
//2
//1
//1
//1
//100
//1
//10000
public class L762PrimeNumberOfSetBits {

    public int countPrimeSetBits(int left, int right) {

        int count = 0;

        for( int i = left; i <= right; i++ ){
            if( isPrime(getBits(i)) ) count++;
        }

        return count;
    }

    public int getBits(int n){
        int count = 0;

        while( n > 0 ){
            count += (n&1);
            n = n >> 1;
        }

        return count;
    }

    public boolean isPrime(int n){

        if( n <= 1 ) return false;

        for( int i = 2; i < n; i++ ){
            if( n % i == 0 ) return false;
        }

        return true;

    }

}
