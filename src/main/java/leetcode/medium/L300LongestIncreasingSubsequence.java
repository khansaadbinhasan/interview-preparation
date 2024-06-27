package leetcode.medium;

//[10,9,2,5,3,7,101,18]
//[0,1,0,3,2,3]
//[7,7,7,7,7,7,7]
//[1]
//[1,1,1,1,2,2,2,2,4,4,4,4,3,3,3,3,3,2,2,2,2]
//[1,2,3,4,5,6,7,7,8,9,10,100,99,98,78,89]
//[1,2,3]
//[3,2,1]
public class L300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        new L300LongestIncreasingSubsequence().run();
    }

    public void run(){
        System.out.println(lengthOfLISBottomUp(new int[]{10,9,2,5,3,7,101,18}));
    }

    int[] maxArr;

    public int lengthOfLIS(int[] nums) {
        maxArr = new int[nums.length];

        for( int i = 0; i < nums.length; i++ ){
            lengthOfLIS(nums, i);
        }

        int max = 0;

        for( int i = 0; i < maxArr.length; i++ ){
            max = Math.max(maxArr[i], max);
        }

        return max;
    }

    public int lengthOfLIS(int[] nums, int ind){
        if( ind >= nums.length ) return 0;
        if( maxArr[ind] != 0 ) return maxArr[ind];

        int max = 0;

        for( int i = ind+1; i < nums.length; i++ ){
            if( nums[i] > nums[ind] ){
                max = Math.max(max, lengthOfLIS(nums, i));
            }
        }

        return maxArr[ind] = max + 1;
    }


    public int lengthOfLISBottomUp(int[] nums) {
        int[] maxArr = new int[nums.length];
        int max = 0;

        for( int i = nums.length-1; i >= 0; i-- ){
            int maxI = 0;
            for( int j = i+1; j < nums.length; j++ ){
                if( nums[j] > nums[i] ) maxI = Math.max(maxI, maxArr[j]);
            }

            maxArr[i] = maxI+1;
            max = Math.max(max, maxArr[i]);
        }

        return max;

    }

}
