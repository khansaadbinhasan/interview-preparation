package leetcode.medium;

//5
//3
//1
//2147483647
//1001010
//0
//9999999
//87867879
public class L633SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {

        for( int i = 0; i <= Math.sqrt(c); i++ ){
            int sqrtB = (int) Math.sqrt(c-i*i);
            if( sqrtB*sqrtB == c-i*i ) {
                System.out.println(i + "  " + sqrtB);
                return true;
            }
        }

        return false;
    }
}
