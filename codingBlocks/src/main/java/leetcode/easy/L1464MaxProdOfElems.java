package leetcode.easy;

//[3,4,5,2]
//[1,5,4,5]
//[3,7]
public class L1464MaxProdOfElems {

    public int maxProduct(int[] nums) {

        int max1 = findMaxAndDelete(nums);
        int max2 = findMaxAndDelete(nums);

        return (max1-1) * (max2-1);

    }

    public int findMaxAndDelete(int[] nums){

        int max = -1;
        int ind = -1;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] > max ) {
                max = nums[i];
                ind = i;
            }
        }

        nums[ind] = -1;

        return max;
    }


}
