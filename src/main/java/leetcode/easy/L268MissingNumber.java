package leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

public class L268MissingNumber {

    public static void main(String[] args) {
        new L268MissingNumber().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(missingNumber(nums));
    }

    public int missingNumberNonBitwise(int[] nums) {

        int[] numbers = new int[nums.length+1];

        Arrays.fill(numbers, 0);

        for (int i = 0; i < nums.length; i++) {
            numbers[nums[i]] = 1;
        }

        for (int i = 0; i < numbers.length; i++) {
            if( numbers[i] == 0 ) return i;
        }

        return -1;
    }

    public int missingNumber(int[] nums){
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i] ^ (i+1);
        }

        return ans;
    }

}
