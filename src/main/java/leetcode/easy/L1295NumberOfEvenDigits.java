package leetcode.easy;

//[12,345,2,6,7896]
//[555,901,482,1771]
public class L1295NumberOfEvenDigits {

    public int findNumbers(int[] nums) {

        int count = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( getNumDigits(nums[i]) % 2 == 0 ) count++;
        }

        return count;
    }

    public int getNumDigits(int n){

        int numDigit = 0;

        while( n > 0 ){
            n = n / 10;
            numDigit++;
        }

        return numDigit;
    }

}
