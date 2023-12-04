package leetcode.easy;

//[3,1,-2,-5,2,-4]
//[-1,1]
//[1,2,-1,-1]
//[-1,-2,-3,1,2,3]
//[1,-1]
public class L2149RearrangeElementsBySign {

    public int[] rearrangeArray(int[] nums) {

        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];

        int posI = 0;
        int negI = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] < 0 ) neg[negI++] = nums[i];
            else pos[posI++] = nums[i];
        }

        posI = 0;
        negI = 0;

        for( int i = 0; i < nums.length; i+=2 ){
            nums[i] = pos[posI++];
            nums[i+1] = neg[negI++];
        }

        return nums;
    }
}
