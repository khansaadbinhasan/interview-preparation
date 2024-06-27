package leetcode.medium;

//[10,5,2,6]
//100
//[1,2,3]
//0
//[1]
//2
//[1,5,3,6,8]
//7
//[10,9,10,4,3,8,3,3,6,2,10,10,9,3]
//19
public class L713SubarrayLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int numSubArr = 0;

        for( int i = 0; i < nums.length; i++ ){
            int product = 1;
            for( int j = i; j < nums.length; j++ ){
                product *= nums[j];
                if( product < k ) numSubArr++;
                else break;
            }
        }

        return numSubArr;
    }
}
