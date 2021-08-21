package arrays;

//1234
//2147483647
public class ReverseInteger {

    public int reverse(int x) {

        int reversedNum = 0;

        while( x != 0 ){
            int lastDigit = x % 10;

            if( Math.abs(reversedNum) > Integer.MAX_VALUE / 10 ||
                    (Math.abs(reversedNum) == Integer.MAX_VALUE / 10 &&
                            Math.abs(lastDigit) > Integer.MAX_VALUE % 10) ) return 0;

            reversedNum = reversedNum * 10 + lastDigit;
            x = x / 10;
        }

        return reversedNum;
    }

}