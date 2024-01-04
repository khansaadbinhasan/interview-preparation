package CTCI.bitManipulation;

import java.util.*;

public class Q3FlipBitsToWin {

    public static void main(String[] args) {
        new Q3FlipBitsToWin().run();
    }

    public void run(){
        System.out.println(longestSequence(71) + " " + maxLengthOf1s(71) + " " + flipBit(71));
        System.out.println(longestSequence(0) + " " + maxLengthOf1s(0) + " " + flipBit(0));
        System.out.println(longestSequence(1) + " " + maxLengthOf1s(1) + " " + flipBit(1) );
        System.out.println(longestSequence(33) + " " + maxLengthOf1s(33) + " " + flipBit(33) );
        System.out.println(longestSequence(1775) + " " + maxLengthOf1s(1775) + " " + flipBit(1775));
        System.out.println(longestSequence(1776) + " " + maxLengthOf1s(1776) + " " + flipBit(1776));
        System.out.println(longestSequence(8888) + " " + maxLengthOf1s(8888) + " " + flipBit(8888));
//        System.out.println(longestSequence(Integer.MIN_VALUE) + " " + maxLengthOf1s(Integer.MIN_VALUE) + " " + flipBit(Integer.MIN_VALUE));
        System.out.println(longestSequence(Integer.MAX_VALUE - 2333) + " " + maxLengthOf1s(Integer.MAX_VALUE - 2333) + " " + flipBit(Integer.MAX_VALUE - 2333));
//        System.out.println(longestSequence(-10000) + " " + maxLengthOf1s(-10000) + " " + flipBit(-10000));
        System.out.println(longestSequence(Integer.MAX_VALUE) + " " + maxLengthOf1s(Integer.MAX_VALUE) + " " + flipBit(Integer.MAX_VALUE));
    }

    public int longestSequence(int num){

        List<Integer> lst = new ArrayList<>();

        int countZeros = 0;
        int countOnes = 0;


        while( num > 0 ){

            if( (num & 1) == 1 ) {

                if( countZeros > 0 ){
                    lst.add(-countZeros);
                    countZeros = 0;
                }

                countOnes++;
            }

            else {

                if( countOnes > 0 ){
                    lst.add(countOnes);
                    countOnes = 0;
                }

                countZeros++;
            }

            num = num >> 1;
        }

        if( countZeros > 0 ) lst.add(countZeros);
        if( countOnes > 0 ) lst.add(countOnes);

//        System.out.println(lst);

        int max = 0;

        for( int i = 0; i < lst.size(); i++ ){
            if( lst.get(i) > 0 ) {
                max = Math.max(max, lst.get(i)+1);
            }

            else if( lst.get(i) < 0 ) {
                if( Math.abs(lst.get(i)) == 1 ){
                    if( i > 0 && i < lst.size()-1 )
                        max = Math.max(max, lst.get(i-1) + 1 + lst.get(i+1));
                }
            }
        }

        return max;
    }


    public int maxLengthOf1s(int num){
        int maxLen = 0;

        boolean zeroStart = (num&1) == 0;

        List<Integer> lst = new ArrayList<>();

        while( num != 0 )
        {
            int num1s = 0;
            while( num != 0 && (num&1) == 1 ){
                num = num >> 1;
                num1s++;
            }
            lst.add(num1s);

            int num0s = 0;
            while( num != 0 && (num&1) == 0 ){
                num = num >> 1;
                num0s++;
            }
            lst.add(num0s);
        }

        if( lst.size() < 1 ) return zeroStart ? 1: lst.get(0);
        if( lst.size() == 2 ) return zeroStart ? lst.get(1)+1: lst.get(0)+1;

        lst.remove(0);
        if( lst.size() == 2 ) return zeroStart ? lst.get(1)+1: lst.get(0)+1;

        for(int i = 2; i < lst.size(); i++){
            maxLen = Math.max(maxLen, Math.max(lst.get(i), lst.get(i-2))+1);
            if( lst.get(i-1) == 1 ){
                maxLen = Math.max(maxLen, lst.get(i-2) + 1 + lst.get(i));
            }
        }

        return maxLen;
    }

    public int flipBit(int a) {
        /* If all 1s, this is already the longest sequence. */
        if (~a == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // We can always have a sequence of at least one 1
        while (a != 0) {
            if ((a & 1) == 1) {
                currentLength++;
            } else if ((a & 1) == 0) {
                /* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }
}
