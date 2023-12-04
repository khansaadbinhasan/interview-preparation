package leetcode.easy;

//[-1,-2,-3,-4,3,2,1]
//[1,5,0,2,-3]
//[-1,1,-1,1,-1]
public class L1822SignOfProductArr {

    public int arraySign(int[] nums) {

        boolean isMinus = false;

        for( int i = 0; i < nums.length; i++ ){

            if( nums[i] == 0 ) return 0;

            if( nums[i] < 0 ) isMinus = !isMinus;
        }


        return isMinus ? -1: 1;
    }

}
