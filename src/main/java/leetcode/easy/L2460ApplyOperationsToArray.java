package leetcode.easy;

//[1,2,2,1,1,0]
//[0,1]
public class L2460ApplyOperationsToArray {

    public int[] applyOperations(int[] nums) {

        int[] afterOperations = new int[nums.length];

        for( int i = 0; i < afterOperations.length; i++ ){
            afterOperations[i] = 0;
        }

        multiply2Set0(nums);
        shift0s(nums, afterOperations);

        return afterOperations;
    }

    public void multiply2Set0(int[] nums){
        for( int i = 0; i < nums.length-1; i++ ){
            if( nums[i] == nums[i+1] ) {
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }
        }
    }

    public void shift0s(int[] nums, int[] afterOperations){

        int j = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] != 0 ){
                afterOperations[j++] = nums[i];
            }
        }
    }
}
