package codingBlocks.hashing;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        new PartitionEqualSubsetSum().run();
    }

    private void run() {
        System.out.println(canPartition(new int[]{20,1,15,3,10,5,8}));
    }

    public boolean canPartition(int[] nums) {

        Arrays.sort(nums);

        int pointer1 = 0;
        int pointer2 = nums.length-1;

        int sum1 = nums[pointer1];
        int sum2 = nums[pointer2];

        while (pointer1 < pointer2){
            if( sum1 < sum2 ){
                pointer1++;
                sum1 += nums[pointer1];
            }

            else if( sum1 > sum2 ){
                pointer2--;
                sum2 += nums[pointer2];
            }

            else if( sum1 == sum2 && pointer2 == pointer1 + 1 ){
                return true;
            }
        }

        return false;
    }

}
