package leetcode.easy;

//[3,2,1,4]
//[1,2]
//[2,1,3]
public class L2733NeitherMaxNorMin {

    public int findNonMinOrMax(int[] nums) {

        if( nums.length <= 2 ) return -1;


        int max = nums[0];
        int min = nums[0];


        for( int i = 0; i < nums.length; i++ ){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] != max && nums[i] != min ) return nums[i];
        }

        return -1;
    }
}
