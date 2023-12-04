package leetcode.easy;

//[1,2,3,4]
//[1,1,2,3]
//[1,2]
//[2,3]
//[1,100]
public class L1313DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {

        int n = 0;

        for( int i = 0; i < nums.length; i+=2 ){
            n += nums[i];
        }

        int[] decodedArr = new int[n];

        int i = 0;

        for( int j = 0; j < nums.length; j+=2 ){

            while( nums[j] > 0 ) {

                decodedArr[i] = nums[j+1];
                i++;

                nums[j]--;
            }
        }

        return decodedArr;
    }


}
