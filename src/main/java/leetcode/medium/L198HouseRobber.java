package leetcode.medium;

//[1,2,3,1]
//[2,7,9,3,1]
//[5,1,2,10]
//[1,3,1]
//[1,2,3,4,5,6,7,8,9]
//[1,1,1,1,1,1,1,1]
//[14,13,15,7,55,32,12,12,12,400]
//[0]
public class L198HouseRobber {

    public int rob(int[] nums) {

        if( nums.length == 1 ) return nums[0];

        for( int i = 2; i < nums.length; i++ ){
            nums[i] += findMax(nums, i-1);
        }

        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }

    public int findMax(int[] nums, int index){
        int maxNum = Integer.MIN_VALUE;

        for( int i = 0; i < index; i++ ){
            maxNum = Math.max(maxNum, nums[i]);
        }

        return maxNum;
    }









    public int rob2(int[] nums) {
        if( nums.length == 1 ) return nums[0];

        int[] dp = new int[nums.length];
        int max = Math.max(nums[0], nums[1]);//7

        //[1,2,3,1]
        //[1,2,4,3]

        //[5,1,2,10]
        //[5,1,7,15]

        dp[0] = nums[0];
        dp[1] = nums[1];

        for( int i = 2; i < nums.length; i++ ){//2 to 3 --> 3
            for( int j = 0; j <= i-2; j++ ){//0 to 1 --> 1
                dp[i] = Math.max(dp[i], dp[j]);//15
            }

            dp[i] = max = Math.max(max, dp[i]+nums[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        new L198HouseRobber().run();
    }

    public void run(){
        System.out.println(rob2(new int[]{2,7,9,3,1}));
    }


















}
