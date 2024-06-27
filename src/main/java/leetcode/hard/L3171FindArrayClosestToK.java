package leetcode.hard;

//[1,2,4,5]
//3
//[1,2,1,2]
//2
//[1]
//10
public class L3171FindArrayClosestToK {
    public int minimumDifference(int[] nums, int k) {
        int minAnd = Integer.MAX_VALUE;

        for( int i = 0; i < nums.length; i++ ){
            int and = nums[i];
            for( int j = i; j < nums.length; j++ ){
                and &= nums[j];
                minAnd = Math.min(minAnd, Math.abs(and-k));
            }

        }

        return minAnd;
    }
}
