package BitMasking;

//8
//7
//4
//1
//100
//100000
//102839829
//2147483647

import java.util.Scanner;

public class IntegerReplacement {

    public static void main(String[] args) {
        new IntegerReplacement().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(integerReplacement(n));
    }


    public int integerReplacement(int n) {

        int count = 0;

        if( n == Integer.MAX_VALUE ) {
            n--;
            count++;
        }

        while( n != 1 ){
            if( isEven(n) ) n = n >> 1;
            else {
                if( isAddOne(n) ) n++;
                else n--;
            }

            System.out.println(n);
            count++;
        }

        return count;
    }

    public boolean isAddOne(int n){

        if( getNumSetBits(n+1) < getNumSetBits(n-1) ) return true;
        else if( getNumSetBits(n+1) > getNumSetBits(n-1) ) return false;

        if( getIndexOfFinalSetBit(n+1) < getIndexOfFinalSetBit(n-1) ) return true;
        else if( getIndexOfFinalSetBit(n+1) > getIndexOfFinalSetBit(n-1) ) return false;

        return false;
    }

    public int getIndexOfFinalSetBit(int n){
        int count = 0;

        while( n != 0 ){
            count++;
            n = n >> 1;
        }

        return count == 0 ? 0: count-1;
    }

    public int getNumSetBits(int n){
        int count = 0;

        while( n != 0 ){
            if( (n & 1) == 1 ) count++;

            n = n >> 1;
        }

        return count;
    }

    public boolean isEven(int n){
        return n % 2 == 0;
    }

}
