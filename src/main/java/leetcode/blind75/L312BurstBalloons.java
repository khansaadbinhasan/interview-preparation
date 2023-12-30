package leetcode.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[3,1,5,8]
//[1,5]
//[1]
//[5,4,3,2,1,9,8,7,6,5]
public class L312BurstBalloons {

    public static void main(String[] args) {
        new L312BurstBalloons().run();
    }

    public void run(){
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }

    public int maxCoins(int[] nums) {

        List<Integer> nums2 = new ArrayList<>();

        nums2.add(1);

        for( int i = 0; i < nums.length; i++ ){
            nums2.add(nums[i]);
        }

        nums2.add(1);

        return coins(nums2, 1);
    }

    public int coins(List<Integer> nums, int start){
        if( nums.size() == 3 ) return nums.get(1);

        int max = 0;
        List<Integer> nums2 = new ArrayList<>(nums);

        for( int i = start; i < nums.size()-1; i++ ){
            int prod = 0;

            while( nums2.size() > 2 ){
                prod += nums2.get(i-1) * nums2.get(i) * nums2.get(i+1);
                nums2.remove(i);
                prod += coins(nums2, i);
            }
            max = Math.max(max, prod);
        }

        return max;
    }

    int[][] dp;

    public int maxCoins2(int[] nums) {
        dp = new int[nums.length+1][nums.length+1];

        for( int i = 0; i < dp.length; i++ ){
            Arrays.fill(dp[i],-1);
        }

        int[] nums2 = new int[nums.length+2];

        nums2[0] = 1;

        for( int i = 0; i < nums.length; i++ ){
            nums2[i+1] = nums[i];
        }

        nums2[nums2.length-1] = 1;

        return dfs(1, nums2.length-2, nums2);
    }

    public int dfs(int l, int r, int[] nums){
        if( l > r ) return 0;

        if( dp[l][r] != -1 ) return dp[l][r];

        dp[l][r] = 0;

        for( int i = l; i <= r; i++ ){
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += dfs(l, i-1, nums) + dfs(i+1, r, nums);
            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }

}
