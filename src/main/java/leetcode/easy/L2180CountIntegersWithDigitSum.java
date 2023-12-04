package leetcode.easy;

//4
//30
//999
//19
//28
//57
//47
//99
public class L2180CountIntegersWithDigitSum {

    public int countEven(int num) {
        int count = 0;

        for( int i = 1; i <= num; i++ ){
            if( isDigitSumEven(i) ) count++;
        }

        return count;
    }

    public boolean isDigitSumEven(int num){
        int digitSum = 0;

        while( num != 0 ){
            digitSum += num % 10;
            num = num / 10;
        }

        return digitSum % 2 == 0;
    }


}
