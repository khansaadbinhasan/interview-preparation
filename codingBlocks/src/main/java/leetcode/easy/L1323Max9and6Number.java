package leetcode.easy;

public class L1323Max9and6Number {

    public int maximum69Number (int num) {

        int digit = 0;

        char[] sNumArr = String.valueOf(num).toCharArray();

        int i = 0;

        while( i < sNumArr.length && sNumArr[i] == '9' ){
            i++;
        }

        if(i < sNumArr.length) sNumArr[i] = '9';

        return Integer.parseInt(String.valueOf(sNumArr));

    }


}
