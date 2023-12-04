package leetcode.easy;

//[1,2,2,4]
//[1,1]
//[1,2,3,3]
//[1,2,3,3,5]
//[1,2,2,3]
//[1,2,2,4]
public class L645SetMismatch {

    public int[] findErrorNums(int[] nums) {

        int[] freqArr = new int[nums.length+1];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]]++;
        }

        int[] err = new int[2];

        for( int i = 1; i < freqArr.length; i++ ){
            if( freqArr[i] == 0 ) err[1] = i;
            if( freqArr[i] == 2 ) err[0] = i;
        }

        return err;
    }

}
