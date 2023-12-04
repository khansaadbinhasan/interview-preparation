package leetcode.easy;


import org.junit.Assert;

//[1,2,10,5,7]
//[2,3,1,2]
//[1,1,1]
//[1,2,10,5,9,7]
//[1,10,2]
//[10,2,1]
//[10,1,2]
//[1,2,1,2]
public class L1909RemoveElementToMakeStrictlyIncrasing {

    public static void main(String[] args) {
        new L1909RemoveElementToMakeStrictlyIncrasing().run();
    }

    private void run() {
        Assert.assertTrue(canBeIncreasing(new int[]{1,2,10,5,7}));
        Assert.assertFalse(canBeIncreasing(new int[]{2,3,1,2}));
        Assert.assertFalse(canBeIncreasing(new int[]{1,1,1}));
        Assert.assertFalse(canBeIncreasing(new int[]{1,2,10,5,9,7}));
        Assert.assertTrue(canBeIncreasing(new int[]{1,10,2}));
        Assert.assertFalse(canBeIncreasing(new int[]{10,2,1}));
        Assert.assertFalse(canBeIncreasing(new int[]{1,2,1,2}));
        Assert.assertTrue(canBeIncreasing(new int[]{10,1,2}));
        Assert.assertTrue(canBeIncreasing(new int[]{105,924,32,968}));
        Assert.assertFalse(canBeIncreasing(new int[]{103,191,918,124,658}));
        System.out.println("All tests passed");
    }

    public boolean canBeIncreasing(int[] nums) {
        int numsToRemove = 0;
        int totalDiffs = 0;

        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] <= nums[i-1] ){
                if( canRemove(nums, i-1) || canRemove(nums, i) ) numsToRemove++;
                totalDiffs++;
            }
        }

        return numsToRemove <= 1 && numsToRemove == totalDiffs;
    }

    public boolean canRemove(int[] nums, int i){

        if( i == 0 || i == nums.length - 1 ){
            return true;
        }

//        if( i > 1 && nums[i-2] < nums[i] ){
//            return true;
//        }

        if( i > 0 && i < nums.length-1 && nums[i-1] < nums[i+1] ){
            return true;
        }

        return false;

    }
}
