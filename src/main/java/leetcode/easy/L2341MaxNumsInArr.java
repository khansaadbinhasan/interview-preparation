package leetcode.easy;

//[1,3,2,1,3,2,2]
//[1,1]
//[0]
//[100,100,1,1,99]
public class L2341MaxNumsInArr {

    public int[] numberOfPairs(int[] nums) {

        int[] freqArr = new int[101];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]]++;
        }

        int pairs = 0;
        int leftovers = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            pairs += freqArr[i] / 2;

            if( freqArr[i] % 2 != 0 ){
                leftovers++;
            }
        }

        return new int[]{pairs, leftovers};
    }
}
