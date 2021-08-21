package arrays;

import java.util.Arrays;
import java.util.Scanner;

//4
//1
//-1 2 1 4
//3
//1
//1
//4
//111
//100 99 10 11
//5
//90
//1 2 3 4 5


public class ThreeSumClosest {

    public static void main(String[] args) {
        new ThreeSumClosest().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);

        System.out.println(threeSumClosest(nums, target));
    }

    public int threeSumClosestBruteForce(int[] nums, int target) {
        int N = nums.length;
        int[][][] threeSums = new int[N][N][N];

        int closest = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N && i != j; j++) {
                for (int k = 0; k < N && i != k && j != k; k++) {

                    threeSums[i][j][k] = nums[i] + nums[j] + nums[k];

                    if (Math.abs(threeSums[i][j][k] - target) < closest) {
                        closest = Math.abs(threeSums[i][j][k] - target);
                        closestSum = threeSums[i][j][k];
                    }
                }
            }
        }

        return closestSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        int[][][] threeSums = new int[N][N][N];

        int closestSum = Integer.MAX_VALUE;
        int closestDist = Integer.MAX_VALUE;

        for (int i = 0; i <= N-3; i++) {

            int pointer1 = i+1;
            int pointer2 = N-1;

            int threeSum = nums[i] + nums[pointer1] + nums[pointer2];

            while( pointer1 < pointer2 ){

                if( Math.abs(threeSum - target) < closestDist ){
                    closestDist = Math.abs(threeSum - target);
                    closestSum = threeSum;
                }

                if( target > threeSum ){
                    threeSum -= nums[pointer1];
                    pointer1++;
                    threeSum += nums[pointer1];
                }

                else if( target < threeSum ){
                    threeSum -= nums[pointer2];
                    pointer2--;
                    threeSum += nums[pointer2];
                }

                else {
                    return threeSum;
                }
            }

        }

        return closestSum;
    }

}