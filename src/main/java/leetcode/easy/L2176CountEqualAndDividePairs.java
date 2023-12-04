package leetcode.easy;

//[3,1,2,2,2,1,3]
//2
//[1,2,3,4]
//1
public class L2176CountEqualAndDividePairs {

    public int countPairs(int[] nums, int k) {
        int pairs = 0;

        for( int i = 0; i < nums.length; i++ ){
            for( int j = 0; j < nums.length; j++ ){
                if( i != j ) {
                    if( nums[i] == nums[j] && i*j % k == 0 ){
                        pairs++;
                    }
                }
            }
        }

        return pairs/2;
    }
}
