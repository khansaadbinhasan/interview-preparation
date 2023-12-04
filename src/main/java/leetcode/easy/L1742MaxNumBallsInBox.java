package leetcode.easy;

//1
//10
//5
//15
//19
//28
public class L1742MaxNumBallsInBox {

    public int countBalls(int lowLimit, int highLimit) {

        int[] nums = new int[50];

        int max = -1;

        for( int i = lowLimit; i <= highLimit; i++ ){

            int sumDig = sumDigits(i);

            nums[sumDig]++;

            max = Math.max(max, nums[sumDig]);
        }

        return max;
    }

    public int sumDigits(int num){

        int sum = 0;

        while( num > 0 ){
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }


}
