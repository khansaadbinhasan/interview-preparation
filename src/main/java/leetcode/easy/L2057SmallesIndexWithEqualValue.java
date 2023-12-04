package leetcode.easy;

//[0,1,2]
//[4,3,2,1]
//[1,2,3,4,5,6,7,8,9,0]
//[4,3,2,1,4]
//[1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9]
//[0]
//[1]
//[2]
public class L2057SmallesIndexWithEqualValue {

    public int smallestEqual(int[] nums) {
        for( int i = 0; i < nums.length; i++ ){
            if( (i % 10) == nums[i] ){
                return i;
            }
        }

        return -1;
    }
}
