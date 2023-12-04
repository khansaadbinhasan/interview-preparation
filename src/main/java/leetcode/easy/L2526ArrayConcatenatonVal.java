package leetcode.easy;

//[7,52,2,4]
//[5,14,13,8,12]
//[1]
//[1,2,3]
//[1,2,3,4,5]
public class L2526ArrayConcatenatonVal {

    public long findTheArrayConcVal(int[] nums) {

        if( nums.length == 1 ) return nums[0];

        long sum = 0;

        for( int i = 0; i < nums.length / 2; i++ ){
            sum += nums[i] * tenPower(nums[nums.length-i-1]) + nums[nums.length-i-1];
        }

        if( nums.length % 2 != 0 ){
            sum += nums[nums.length/2];
        }

        return sum;
    }

    private long tenPower(int num){

        long power = 1;

        while( num != 0 ){
            num = num/10;
            power = power*10;
        }

        return power;
    }}
