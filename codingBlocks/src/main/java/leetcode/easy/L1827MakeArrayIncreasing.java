package leetcode.easy;

//[1,1,1]
//[1,5,2,4,1]
//[8]
public class L1827MakeArrayIncreasing {

    public int minOperations(int[] nums) {

        int countOps = 0;

        for( int i = 1; i < nums.length; i++ ){
            int diff = nums[i] - nums[i-1];

            if( diff <= 0 ){
                nums[i] = nums[i] - diff + 1;
                countOps = countOps - diff + 1;
            }
        }

        return countOps;
    }

}
