package leetcode.easy;

//[1,2,3,4,5]
//5
//3
//[1]
//1
//0
//[1,1,1,1,1,1,1,1,1,1]
//1
//0
public class L1848MinDistToTargetElem {

    public int getMinDistance(int[] nums, int target, int start) {

        int minDist = 1000_000;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == target ){
                minDist = Math.min(minDist, Math.abs(i-start));
            }
        }

        return minDist;

    }
}
