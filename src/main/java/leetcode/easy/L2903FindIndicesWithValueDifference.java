package leetcode.easy;

//[5,1,4,1]
//2
//4
//[2,1]
//0
//0
//[1,2,3]
//2
//4
//[1]
//0
//0
public class L2903FindIndicesWithValueDifference {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for( int i = 0; i < nums.length; i++ ){
            for( int j = i; j < nums.length; j++ ){
                if( (j - i) >= indexDifference && Math.abs(nums[i]-nums[j]) >= valueDifference ){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
