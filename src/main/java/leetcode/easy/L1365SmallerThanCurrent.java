package leetcode.easy;

//[8,1,2,2,3]
//[6,5,4,8]
//[7,7,7,7]
//[0,1]
//[1,3,2]
public class L1365SmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] numArr = new int[nums.length];

        for( int i = 0; i < nums.length; i++ ){
            for( int j = 0; j < nums.length; j++ ){
                if( nums[i] > nums[j] ) numArr[i]++;
            }
        }

        return numArr;
    }
}
