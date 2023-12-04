package leetcode.easy;

//[2, 1, 3]
//[1, 3, 3, 2]
//[1, 1]
//[3, 4, 4, 1, 2, 1]
//[1,3]
//[1,2,3,4,5,5]
//[5,4,3,2,1,1]
//[4,4,3,2,1]
//[1,2]
public class L2784CheckIfArrayIsGood {

    public boolean isGood(int[] nums) {

        int[] good = new int[nums.length];

        boolean isLast = false;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] >= good.length ) return false;

            if( nums[i] == nums.length-1 ){
                if( isLast ) {
                    good[nums[i]] = nums[i];
                    continue;
                }
                isLast = true;
            }

            good[nums[i]-1] = nums[i];
        }

        for( int i = 0; i < good.length; i++ ){
            if( good[i] == 0 ) return false;
        }

        return true;
    }
}
