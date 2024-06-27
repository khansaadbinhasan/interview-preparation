package leetcode.blind75;

//[1,2,3,1]
//[2,7,9,3,1]
//[5,1,2,10]
//[1,3,1]
//[1,2,3,4,5,6,7,8,9]
//[1,1,1,1,1,1,1,1]
//[14,13,15,7,55,32,12,12,12,400]
//[0]
//[1,2]
//[2,2]
//[2,1]
//[2,3,2]
//[1,2,3,1]
//[1,2,3]
public class L198HouseRobberII {

    public int rob(int[] nums) {//[1,2,3,4,5] → 8
        if( nums.length == 1 ) return nums[0];
        int num = nums[0];
        nums[0] = Integer.MIN_VALUE;
        int res1 = rob1(nums);
        nums[0] = num;
        nums[nums.length-1] = Integer.MIN_VALUE;
        int res2 = rob1(nums);

        return Math.max(res1, res2);
    }

    public int rob1(int[] nums) {
        if( nums.length == 1 ) return nums[0];

        int[] dp = new int[nums.length];
        int max = Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = nums[1];

        for( int i = 2; i < nums.length; i++ ){
            for( int j = 0; j <= i-2; j++ ){
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] = max = Math.max(max, dp[i]+nums[i]);
        }

        return max;
    }



    public int rob3(int[] nums) {//[1,2,3,4,5] → 8
        if( nums.length < 4 ){
            int max = 0;
            for( int i = 0; i < nums.length; i++){
                max=Math.max(max, nums[i]);
            }
            return max;
        }


        int n = nums.length;//5
        int[] dp = new int[nums.length];//[0,2,3,6,8]
        int res = 0;//8

        dp[1] = nums[1];
        dp[2] = nums[2];

        for( int i = 3; i < n; i++ ){//4, 5
            int max = 0;//3
            for( int j = 1; j <= i-2; j++ ){//2,2
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + nums[i];
            res = Math.max(res, dp[i]);
        }

//i=0
        int max = 0;//4
        for( int j = 2; j < n-1; j++ ){
            max = Math.max(max, dp[j]);
        }

        return Math.max(res, max + nums[0]);
    }















}
