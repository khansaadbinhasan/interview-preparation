package leetcode.medium;

//[1,3,4,2,2]
//[3,1,3,4,2]
//[1,1]
//[1,1,2]
public class L287FindDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int[] freqArr = new int[nums.length];

        for( int i = 0; i < nums.length; i++ ){
            if( freqArr[nums[i]] > 0 ) return nums[i];

            freqArr[nums[i]]++;
        }

        return -1;
    }

}
