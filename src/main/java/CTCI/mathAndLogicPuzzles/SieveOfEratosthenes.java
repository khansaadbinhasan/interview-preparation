package CTCI.mathAndLogicPuzzles;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        new SieveOfEratosthenes().run();
    }

    public void run(){

        boolean[] primes = sieveOfEratosthenes(50);

        for (int i = 0; i < primes.length; i++) {
            if( primes[i] ) System.out.println(i);
        }
    }

    boolean[] sieveOfEratosthenes(int max){

        boolean[] flags = new boolean[max+1];
        int count = 0;

        Arrays.fill(flags, true);

        flags[0] = false;
        flags[1] = false;

        int prime = 2;

        while( prime <= Math.sqrt(max) ){

            crossOff(flags, prime);

            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    void crossOff(boolean[] flags, int prime){
        for (int i = prime*prime; i < flags.length; i+=prime) {
            flags[i] = false;
        }
    }

    int getNextPrime(boolean[] flags, int prime){
        int next = prime+1;

        while( next < flags.length && !flags[next] ){
            next++;
        }

        return next;
    }

}
