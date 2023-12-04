package leetcode.easy;

//[3,5]
//[0,0]
//[0,4,3,0,4]
//[3,6,7,7,0]
public class L1608SpecialArrayWithXElems {

    public int specialArray(int[] nums) {

        int x = -1;

        for( int i = nums.length; i >= 0; i-- ){
            int count = 0;
            for( int j = 0; j < nums.length; j++ ){
                if( nums[j] >= i ) count++;
            }
            if( count == i ) x = Math.max(x, count);
        }

        return x;
    }
}
