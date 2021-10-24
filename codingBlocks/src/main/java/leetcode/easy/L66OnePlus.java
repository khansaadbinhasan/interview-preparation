package leetcode.easy;

public class L66OnePlus {

    public int[] plusOne(int[] digits) {

        if( digits[digits.length-1] != 9 ) {
            digits[digits.length-1]++;
            return digits;
        }

        int carry = 0;

        for(int i = digits.length-1; i >= 0; i--){

            if( digits[i] == 9 ) {
                digits[i] = 0;
                carry = 1;
            }

            else {
                digits[i]+=1;
                carry = 0;
                break;
            }

        }

        if( carry == 1 ) {

            int[] newDigits = new int[digits.length+1];

            newDigits[0] = 1;

            for( int i = 1; i < newDigits.length; i++ ){
                newDigits[i] = digits[i-1];
            }

            return newDigits;
        }

        return digits;
    }
}
