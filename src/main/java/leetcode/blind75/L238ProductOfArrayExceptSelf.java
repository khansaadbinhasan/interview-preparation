package leetcode.blind75;

//[1,2,3,4]
//[-1,1,0,-3,3]
public class L238ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] productExceptSelfArr = new int[nums.length];

        int[] numsArr1 = new int[nums.length];
        int[] numsArr2 = new int[nums.length];

        numsArr1[0] = 1;
        numsArr2[numsArr1.length-1] = 1;

        for (int i = 0; i < numsArr1.length - 1; i++)
            numsArr1[i+1] = numsArr1[i] * nums[i];

        for (int i = numsArr2.length-1; i > 0; i--)
            numsArr2[i-1] = numsArr2[i] * nums[i];

        for (int i = 0; i < nums.length; i++)
            productExceptSelfArr[i] = numsArr1[i] * numsArr2[i];

        return productExceptSelfArr;
    }

}
