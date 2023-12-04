package leetcode.easy;

//521
//111
//886996
//1
//12
//1234
public class L2544AlternatingDigitSum {

    public int alternateDigitSum(int n) {
        int sum = 0;
        boolean isPlus = true;

        n = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());

        while( n != 0 ){
            int digit = n % 10;
            n = n / 10;

            if( !isPlus ) {
                digit = -1 * digit;
            }

            sum += digit;
            isPlus = !isPlus;
        }

        return sum;
    }

}
