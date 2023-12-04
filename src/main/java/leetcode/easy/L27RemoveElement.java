package leetcode.easy;

//[3,2,2,3]
//3
//[0,1,2,2,3,0,4,2]
//2
//[]
//0
//[1,2,3,4]
//1
//[1,1,1,1]
//1
//[1,2,3,4]
//5

public class L27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == val ){
                nums[i] = -1000;
                count++;
            }
        }


        for( int i = 0; i < nums.length; i++ ){

            int j = i;

            while( j < nums.length && nums[j] != -1000 ){
                j++;
            }

            int index1 = j;

            while( j < nums.length && nums[j] == -1000 ){
                j++;
            }

            if( index1 < nums.length && j < nums.length ){
                int temp = nums[index1];
                nums[index1] = nums[j];
                nums[j] = temp;
            }
        }


        return nums.length - count;
    }
}
