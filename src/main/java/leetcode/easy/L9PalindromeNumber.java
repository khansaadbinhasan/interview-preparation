package leetcode.easy;

import java.util.*;

//121
//-121
//10
//-101
//0
//-2147483647
//2147483646
public class L9PalindromeNumber {

    public boolean isPalindrome(int x) {
        if( x < 0 ) return false;

        int numOld = x;
        int num = 0;

        while( numOld != 0 ){
            num = num*10 + numOld % 10;
            numOld = numOld / 10;
        }

        return num == x;
    }
}
