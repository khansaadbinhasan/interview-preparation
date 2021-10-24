package leetcode.easy;

//[4,2,5,7]
//[2,3]
public class L922SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {

        int[] ans = new int[nums.length];

        int oddI = 1;
        int evenI = 0;


        for( int i = 0; i < nums.length; i++ ){

            if( nums[i] % 2 == 0 ){
                ans[evenI] = nums[i];
                evenI += 2;
            }

            else{
                ans[oddI] = nums[i];
                oddI += 2;
            }
        }


        return ans;
    }

}
