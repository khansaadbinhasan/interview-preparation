package codingBlocks.DP;

import java.util.Scanner;

public class SmartRobber {

    public static void main(String[] args) {
        new SmartRobber().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }

            System.out.println(rob(nums));
        }
    }

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
}
