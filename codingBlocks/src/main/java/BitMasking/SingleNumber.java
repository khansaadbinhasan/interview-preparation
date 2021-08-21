package BitMasking;

import java.util.Scanner;

public class SingleNumber {

    public static void main(String[] args) {
        new SingleNumber().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
