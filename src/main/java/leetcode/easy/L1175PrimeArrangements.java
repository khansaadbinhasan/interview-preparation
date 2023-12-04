package leetcode.easy;

import java.math.BigInteger;

//5
//100
//30
//12
//15
//27
//93
//45
public class L1175PrimeArrangements {

    public static void main(String[] args) {
        new L1175PrimeArrangements().numPrimeArrangements(10);
    }

    public int numPrimeArrangements(int n) {
        int numPrimes = 0;

        for( int i = 1; i <= n; i++ ){
            numPrimes += isPrime(i);
        }

        BigInteger primeFact = fact(numPrimes);
        BigInteger nonPrimeFact = fact(n - numPrimes);
        BigInteger modVal = new BigInteger(String.valueOf((int) Math.pow(10, 9) + 7));
        return primeFact.multiply(nonPrimeFact).mod(modVal).intValue();
    }

    public BigInteger fact(int n){
        BigInteger fact = new BigInteger("1");

        for( int i = 2; i <= n; i++ ){
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }

        return fact;
    }

    public int isPrime(int n){
        if( n == 1 ) return 0;

        for( int i = 2; i <= Math.sqrt(n); i++ ){
            if( n % i == 0 ) return 0;
        }

        return 1;
    }
}
