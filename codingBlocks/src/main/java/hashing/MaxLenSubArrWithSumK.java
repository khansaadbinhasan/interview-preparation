package hashing;

import java.util.*;

public class MaxLenSubArrWithSumK {

    public static void main(String[] args) {
        new MaxLenSubArrWithSumK().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String inpStr = sc.nextLine().trim();

        String[] inpArr = inpStr.substring(1,inpStr.length()-1).split(",");

        int[] nums = new int[inpArr.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(inpArr[i]);
        }

        int target = sc.nextInt();

        System.out.println(maxLenSubArr(nums, target));
    }

    public int maxLenSubArr(int[] nums, int target){

        if( nums.length == 0 ) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int maxLen = Integer.MIN_VALUE;

        for( int key: map.keySet() ){
            if( map.containsKey(key-target) ){
                int keyVal = Math.abs(map.get(key) - map.get(key-target));
                if( keyVal > maxLen ){
                    maxLen = keyVal;
                }
            }
        }

        return maxLen;
    }
}