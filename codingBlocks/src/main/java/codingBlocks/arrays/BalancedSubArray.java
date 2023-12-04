package codingBlocks.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//0
//1
//0 1
//0 0 1 1 1 0
//0 0 1 0 0 0 0 1 1 1
//1 1 1 0 0 1 1 0 0 0
//0 0 0 1 1 1 0 0 0 1 0
//1 0 1 1 1
//1 1 1 0 0
public class BalancedSubArray {

    public static void main(String[] args) {
        new BalancedSubArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(getBalancedSubArray(nums));
    }

    public int getBalancedSubArray(int[] nums){
        int count = 0;
        int ans = 0;

        Map<Integer, Integer> countIndex = new HashMap<>();

        countIndex.put(count,-1);

        for (int i = 0; i < nums.length; i++) {

            if( nums[i] == 0 ) count--;
            else if( nums[i] == 1 ) count++;

            if( countIndex.containsKey(count) ) ans = Math.max(ans, i - countIndex.get(count));
            else countIndex.put(count, i);
        }

        return ans;
    }

}
