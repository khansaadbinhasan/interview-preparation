package leetcode.easy;

//34
//6
//10
//10
//1
//4
//1
//10
//76
//10
//100
//7
public class L1837SumOfDigitsinBaseK {

    public int sumBase(int n, int k) {

        int sum = 0;

        while( n > 0 ){
            sum += n % k;
            n = n / k;
        }

        return sum;
    }

}
