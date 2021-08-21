package hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContinousSubArray {

    public static void main(String[] args) {
        new ContinousSubArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String inpStr = sc.nextLine().trim();
        String[] inpArr = inpStr.substring(1, inpStr.length()-1).split(",");

        int[] nums = new int[inpArr.length];

        for (int i = 0; i < inpArr.length; i++) {
            nums[i] = Integer.parseInt(inpArr[i]);
        }

        int k = sc.nextInt();

        System.out.println(checkSubarraySum(nums, k) ? "True": "False");
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }

        Set<Integer> intSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if( intSet.contains(nums[i] % k) ) return true;
            intSet.add(nums[i] % k);
        }

        return false;
    }

}
