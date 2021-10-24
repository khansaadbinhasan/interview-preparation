package codingBlocks.arrays;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        new TwoSum().twoSum(new int[]{1,3,5,7,11,6,8}, 10);
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int num1 = -1;
        int num2 = -1;

        for (int i = 0; i < nums.length; i++) {

            if( hashMap.containsKey(nums[i]) && (nums[i]+nums[i] == target)) {
                num1 = nums[i];
                num2 = nums[i];

                int[] ans = new int[2];
                int ind = 0;

                for (int j = 0; j < nums.length; j++) {
                    if (num1 == nums[j] || num2 == nums[j]) {
                        ans[ind] = j;
                        ind++;
                    }
                }

                return ans;
            }

            hashMap.put(nums[i], target-nums[i]);

        }


        Iterator itr = hashMap.entrySet().iterator();



        while( itr.hasNext() ){
            Map.Entry pair = (Map.Entry) itr.next();

            int key = (int) pair.getKey();
            int val = (int) pair.getValue();

            itr.remove();

            if( hashMap.get(val) != null && hashMap.get(val).equals(key) ){
                num1 = key;
                num2 = val;

                break;
            }
        }

        int[] ans = new int[2];
        int ind = 0;

        for (int i = 0; i < nums.length; i++) {
            if (num1 == nums[i] || num2 == nums[i]) {
                ans[ind] = i;
                ind++;
            }
        }

        return ans;
    }

}
