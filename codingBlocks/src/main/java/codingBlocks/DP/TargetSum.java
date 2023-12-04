package codingBlocks.DP;

import java.util.*;

//5 3
//1 1 1 1 1

//1 100
//1

//[1,1,1,1,1]
//3
//[1]
//1
//[1,3,4]
//5
//[1]
//100
//[1,7,4,1,4,8,343,12]
//98
//[1,7,4,1,4,8,3,12]
//10
//[0,0,0,0,0,0,0,0,1]
//1

public class TargetSum {

    public static void main(String[] args) {
        new TargetSum().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for(int num: nums){
            sum += num;
        }

        int M = nums.length;
        int N = sum * 2 + 1;

        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], 0);
        }

        int[] a = new int[N];

        Map<Integer, Integer> sumInd = new HashMap<>();

        for (int j = 0; j < N; j++) {
            int key = -1*sum + j;

            a[j] = key;
            sumInd.put(key, j);
        }

        for (int j = 0; j < N; j++) {
            if( Math.abs(a[j]) == nums[0] ) dp[0][j] = 1;
            if( nums[0] == 0 && a[j] == 0 ) dp[0][j] = 2;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {

                int subVals = 0;
                int addVals = 0;

                if( sumInd.containsKey(a[j] - nums[i])  ) subVals = dp[i-1][sumInd.get(a[j] - nums[i])];
                if( sumInd.containsKey(a[j] + nums[i])  ) addVals = dp[i-1][sumInd.get(a[j] + nums[i])];

                dp[i][j] = subVals + addVals;
            }
        }

        return sumInd.containsKey(target) ? dp[M-1][sumInd.get(target)]: 0;
    }
}
