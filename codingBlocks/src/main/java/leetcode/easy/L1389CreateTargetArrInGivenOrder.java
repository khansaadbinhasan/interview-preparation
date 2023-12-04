package leetcode.easy;

//[0,1,2,3,4]
//[0,1,2,2,1]
//[1,2,3,4,0]
//[0,1,2,3,0]
//[1]
//[0]
public class L1389CreateTargetArrInGivenOrder {

    public int[] createTargetArray(int[] nums, int[] index) {

        int[] target = new int[nums.length];

        for( int i = 0; i < index.length; i++ ){
            for( int j = 0; j < i; j++ ){
                if( index[j] >= index[i] ) index[j]++;
            }
        }

        for( int i = 0; i < target.length; i++ ){
            target[index[i]] = nums[i];
        }

        return target;
    }
}
