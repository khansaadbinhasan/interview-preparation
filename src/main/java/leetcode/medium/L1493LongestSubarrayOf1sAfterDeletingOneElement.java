package leetcode.medium;

//[1,1,0,1]
//[0,1,1,1,0,1,1,0,1]
//[1,1,1]
//[1,0,1]
//[0,0,0]
//[1,1,1,1,0,1,1,1,0,0,0,0,0,1]
//[1,0,0,0,1,1,1,1,0,1,0,1,0,1,0,1,0]
//[0,1,1,1,0,1,1]
public class L1493LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        new L1493LongestSubarrayOf1sAfterDeletingOneElement().run();
    }

    public void run(){
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

    public int longestSubarray(int[] nums) {

        int max = 0;
        int curr = 0;

        int[] clone = nums.clone();

        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] == 0 && nums[i-1] == 0 ){
                clone[i] = Integer.MIN_VALUE;
            }
        }

        boolean deletedOne = false;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == 1 ) {
                curr++;
            }
            else {
                if( deletedOne ) {
                    curr = 0;
                    deletedOne = false;

                }
                deletedOne = true;
                if( clone[i] == Integer.MIN_VALUE ) {
                    curr = 0;
                    deletedOne = false;
                }
            }
            max = Math.max(max, curr);
        }

        curr = 0;

        for( int i = nums.length-1; i >= 0; i-- ){
            if( nums[i] == 1 ) {
                curr++;
            }
            else {
                if( deletedOne ) {
                    curr = 0;
                    deletedOne = false;
                }
                deletedOne = true;
                if( clone[i] == Integer.MIN_VALUE ) {
                    curr = 0;
                    deletedOne = false;
                }
            }
            max = Math.max(max, curr);
        }

        if( max == nums.length ) return nums.length-1;

        return max;
    }

}
