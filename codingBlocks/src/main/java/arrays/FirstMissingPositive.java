package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class FirstMissingPositive {

    public static void main(String[] args) {
        new FirstMissingPositive().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();

        int missingPositive = firstMissingPositive(nums);

        System.out.println(missingPositive);
    }

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= 0) nums[i] = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int numAtI = nums[i];

            if (numAtI < 0) numAtI = -1 * numAtI;

            int numAtIInd = numAtI - 1;

            if (numAtI <= nums.length) {
                if (numAtI > 0 && nums[numAtIInd] > 0) nums[numAtIInd] = -1 * nums[numAtIInd];
            }

        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) return i + 1;

        return nums.length + 1;
    }
}
