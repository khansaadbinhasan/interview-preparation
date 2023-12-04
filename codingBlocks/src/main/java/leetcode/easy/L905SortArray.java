package leetcode.easy;

//[3,1,2,4]
//[0]
public class L905SortArray {

    public int[] sortArrayByParity(int[] nums) {

        int[] numbers = new int[nums.length];

        int pointer = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( isEven(nums[i]) ) numbers[pointer++] = nums[i];
        }

        for( int i = 0; i < nums.length; i++ ){
            if( !isEven(nums[i]) ) numbers[pointer++] = nums[i];
        }

        return numbers;
    }

    public boolean isEven(int n){
        return n % 2 == 0;
    }

}
