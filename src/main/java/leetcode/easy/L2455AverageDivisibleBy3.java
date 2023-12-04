package leetcode.easy;

//[1,3,6,10,12,15]
//[1,2,4,7,10]
//[1]
//[3]
//[1,12,6,10,12,24,27,36,18]
public class L2455AverageDivisibleBy3 {

    public int averageValue(int[] nums) {

        int count = 0;
        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] % 6 == 0 ) {
                sum += nums[i];
                count++;
            }
        }

        return count != 0 ? sum / count: 0;
    }

}
