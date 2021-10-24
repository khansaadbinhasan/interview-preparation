package leetcode.easy;

//[1]
//0
//[0,10]
//2
//[1,3,6]
//3
public class L908SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {

        int min = nums[0];
        int max = nums[0];


        for( int i = 1; i < nums.length; i++ ){
            min = Math.min(min, nums[i]);
            max = Math.max(max , nums[i]);
        }

        int diff = max-min;

        if( diff >= 2*k ) return (diff-2*k);

        return 0;
    }

}
