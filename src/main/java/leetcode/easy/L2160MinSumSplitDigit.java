package leetcode.easy;

import java.util.*;

//2932
//4009
//1000
//1234
//9999
public class L2160MinSumSplitDigit {

    public int minimumSum(int num) {
        List<Integer> digits = getDigits(num);

        Collections.sort(digits);

        int num1 = 0;
        int num2 = 0;

        for( int i = 0; i < digits.size()-1; i+=2 ){
            num1 = num1*10 + digits.get(i);
            num2 = num2*10 + digits.get(i+1);
        }

        if( digits.size() % 2 != 0 ) num1 = num1*10 + digits.get(digits.size()-1);

        return num1+num2;
    }

    public List<Integer> getDigits(int num){
        List<Integer> digits = new LinkedList<>();

        while( num != 0 ){
            digits.add( num % 10 );
            num = num / 10;
        }

        return digits;
    }
}
