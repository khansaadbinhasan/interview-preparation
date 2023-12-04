package leetcode.easy;

//[1,2,1]
//[1,3,2,1]
//[1]
//[1,2,3,4]
//[1,2,1]
//[1,5,2,7]
//[1,2,3,4,8,9]
//[1,2]

public class L1929ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n*2];

        for( int i = 0; i < n; i++ ){
            ans[n+i] = ans[i] = nums[i];
        }

        return ans;
    }

}
