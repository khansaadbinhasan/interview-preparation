package leetcode.easy;

//17
//2
//1
//1000
public class L2595EvenAndOddBits {

    public int[] evenOddBit(int n) {
        int index = 0;
        int even = 0;
        int odd = 0;

        while( n > 0 ){
            if( (n & 1) == 1 ) {
                if( index % 2 == 0 ) even++;
                else odd++;
            }

            n = n >>> 1;
            index++;

        }

        return new int[]{even, odd};
    }
}
