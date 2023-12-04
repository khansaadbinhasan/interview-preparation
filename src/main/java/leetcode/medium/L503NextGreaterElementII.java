package leetcode.medium;

public class L503NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];

        for( int i = 0; i < nums.length; i++ ){

            result[i] = -1;

            for( int j = i == nums.length-1? 0:i+1; j < nums.length && j != i; j++ ){

                if( nums[j] > nums[i] ){
                    result[i] = nums[j];
                    break;
                }

                if( j == nums.length - 1 ) j = -1;
            }
        }

        return result;

    }


}
