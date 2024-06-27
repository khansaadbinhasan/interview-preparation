package codingBlocks.DP;

import java.util.Arrays;
import java.util.Scanner;

public class BookStore {

    public static void main(String[] args) {
        new BookStore().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N+2];

        nums[0] = 1;
        nums[N+1] = 1;

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(getMaxBookPrice(nums, 0, N+1));
    }

    int[][] dp = new int[1000][1000];

    public int getMaxBookPrice(int[] nums, int left, int right){

        if( right - left < 2 ) return 0;

        if( dp[left][right] != -1 ) return dp[left][right];

        int maxPrice = 0;

        for (int i = left+1; i < right; i++) {
            maxPrice = Math.max(maxPrice,
                                nums[left] * nums[i] * nums[right] + getMaxBookPrice(nums, left, i) + getMaxBookPrice(nums, i, right));
        }

        return dp[left][right] = maxPrice;
    }

}
