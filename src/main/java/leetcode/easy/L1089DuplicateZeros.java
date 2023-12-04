package leetcode.easy;

//[1,0,2,3,0,4,5,0]
//[1,2,3]
//[0]
//[0,0]
//[0,1,0]
//[1,0,1]
//[0,0,0,0,0,0,0,0]
//[1,0,1,0,1,0]
public class L1089DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for( int i = 0; i < arr.length; i++ ){
            if( arr[i] == 0 ) len++;
        }

        int[] nums = new int[arr.length];

        for( int i = 0; i < arr.length; i++ ){
            nums[i] = arr[i];
        }


        for( int i = 0, j = 0; i < arr.length && j < nums.length; i++, j++ ){
            arr[i] = nums[j];
            if( arr[i] == 0 && i+1 < arr.length ){
                arr[i+1] = 0;
                i++;
            }
        }
    }
}
