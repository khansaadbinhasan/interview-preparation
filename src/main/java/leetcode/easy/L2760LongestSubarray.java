package leetcode.easy;

//[3,2,5,4]
//5
//[1,2]
//2
//[2,3,4,5]
//4
//[1]
//1
//[1]
//2
//[1,2,3,4,5,6]
//6
//[2]
//2
//[4]
//1
//[2,8]
//4
//[2,2]
//18
//[4,3,1]
//4
//[1,10,5]
//9
public class L2760LongestSubarray {

    public static void main(String[] args) {
        new L2760LongestSubarray().run();
    }

    public void run(){
        System.out.println(longestAlternatingSubarray(new int[]{2,3,4,5}, 4));
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int len = 0;

        for( int i = 0; i < nums.length; i++ ){
            int count = 0;
            if( nums[i] % 2 != 0 ) continue;
            int j = i+1;

            if( nums[i] <= threshold ) count = 1;

            for( j = i+1; j < nums.length; j++ ){
                if( nums[j] % 2 == nums[j-1] % 2 ) break;
                if( nums[j-1] > threshold ) break;
                count++;
            }

            if( j == nums.length-1 && nums[j] <= threshold ) count++;

            len = Math.max(len, count);
        }

        return len;
    }

}
