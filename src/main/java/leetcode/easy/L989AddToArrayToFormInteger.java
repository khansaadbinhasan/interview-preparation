package leetcode.easy;

import java.util.*;

//[1,2,0,0]
//34
//[2,7,4]
//181
//[2,1,5]
//806
//[1]
//1
//[1]
//999
//[9,9,9,9,9]
//999
//[1,1,9,9,9]
//999
public class L989AddToArrayToFormInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {

        LinkedList<Integer> lst = new LinkedList<>();

        int carry = 0;

        for( int i = num.length-1; i >= 0; i-- ){
            int sum = num[i] + k%10 + carry;
            k = k / 10;

            carry = 0;

            if( sum > 9 ){
                sum = sum % 10;
                carry = 1;
            }

            lst.addFirst(sum);
        }

        while( k != 0 ){
            int sum = k%10 + carry;
            k = k / 10;

            carry = 0;

            if( sum > 9 ){
                sum = sum % 10;
                carry = 1;
            }

            lst.addFirst(sum);
        }

        if( carry == 1 ) {


            lst.addFirst(1);
        }

        return lst;

    }

}
