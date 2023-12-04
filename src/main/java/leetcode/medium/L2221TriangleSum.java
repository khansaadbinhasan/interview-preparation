package leetcode.medium;

//[1,2,3,4,5]
//[5]
//[9,9,9,9,9,9,9,9,9,9]
//[9,9,9,9,9,9,9,9,9]
public class L2221TriangleSum {

    public int triangularSum(int[] nums) {

        int numLen = nums.length;

        while( numLen > 1 ){
            int i = 0;
            for( i = 0; i < nums.length-1 && nums[i] != -1; i++ ){
                nums[i] = (nums[i] + nums[i+1])%10;
            }

            nums[i] = -1;
            numLen--;
        }

        return nums[0];
    }


}
