package leetcode.medium;

import java.util.*;

//100
//300
//1000
//13000
//10
//1000000000
//10
//989898898
//10
//877464677
//1111111
//191897181
//10
//11
//8511
//23553
//744
//1928
//15753396
//106864044
public class L1291SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        //1234
        //2345
        //3456
        //4567
        //5678
        //6789
        //12345
        int lowDigs = numDigits(low);
        int ones = getN1s(lowDigs);

        List<Integer> sortedList = new LinkedList<>();
        int startingNumber = getStartingNumber(lowDigs);

        while( startingNumber < low ){
            if( lowDigs == 9 ) break;
            startingNumber += ones;
            if( startingNumber >= low ) break;
            if( isLastDigit9(startingNumber) ){
                lowDigs++;
                startingNumber = getStartingNumber(lowDigs);
                ones = getN1s(lowDigs);
            }
        }

        if( startingNumber < low ) return sortedList;

        while( startingNumber <= high ){
            if( isLastDigit9(startingNumber) ){
                sortedList.add(startingNumber);
                lowDigs++;
                startingNumber = getStartingNumber(lowDigs);
                ones = getN1s(lowDigs);
            }
            if( startingNumber > high ) break;
            sortedList.add(startingNumber);
            if( lowDigs == 9 ) break;
            startingNumber += ones;
        }

        return sortedList;
    }

    public int numDigits(int n){
        int numDigits = 0;

        while( n != 0 ){
            n = n / 10;
            numDigits++;
        }

        return numDigits;
    }

    public boolean isLastDigit9(int n){
        return n % 10 == 9;
    }

    public int getN1s(int n){
        int num = 0;
        while( n > 0 ){
            num = num*10 + 1;
            n--;
        }
        return num;
    }

    public int getStartingNumber(int n){
        int startingNumber = 0;
        int i = 1;

        while( n != 0 ){
            startingNumber = startingNumber*10 + i++;
            n--;
        }

        return startingNumber;
    }
}
