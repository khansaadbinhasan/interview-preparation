package leetcode.easy;

//[0,2,1,5,3,4]
//[5,0,1,2,3,4]
//[0]
//[4,3,2,1,0]
//[3,2,1,0]
//[2,3,1,0]
//[0,1]
public class L1920BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {

        int[] numsAns = new int[nums.length];

        for( int i = 0; i < nums.length; i++ ){
            numsAns[i] = nums[nums[i]];
        }

        return numsAns;
    }

}
