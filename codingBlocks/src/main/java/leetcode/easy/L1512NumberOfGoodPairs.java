package leetcode.easy;

//[1,2,3,1,1,3]
//[1,1,1,1]
//[1,2,3]
//[1]
//[1,2]
//[3,2,1,4,5]
public class L1512NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {

        int count = 0;

        for( int i = 0; i < nums.length; i++ ){
            for( int j = 0; j < nums.length; j++ ){
                if( nums[i] == nums[j] && i < j ) count++;
            }
        }

        return count;
    }

}
