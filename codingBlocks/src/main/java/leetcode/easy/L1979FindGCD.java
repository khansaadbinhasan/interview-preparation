package leetcode.easy;

//[2,5,6,9,10]
//[7,5,6,8,3]
//[3,3]
public class L1979FindGCD {

    public int findGCD(int[] nums) {

        int min = findMin(nums);
        int max = findMax(nums);

        int gcd = 1;

        for( int i = 1; i <= min; i++ ){
            if( max % i == 0 && min % i == 0 ) gcd = i;
        }

        return gcd;
    }

    public int findMax(int[] nums){

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if( nums[i] > max ) max = nums[i];
        }

        return max;
    }

    public int findMin(int[] nums){

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if( nums[i] < min ) min = nums[i];
        }

        return min;
    }


}
