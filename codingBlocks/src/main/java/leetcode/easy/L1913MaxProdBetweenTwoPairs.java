package leetcode.easy;

//[5,6,2,7,4]
//[4,2,5,9,7,4,8]

public class L1913MaxProdBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {

        int[] nums2 = nums.clone();

        int numMin1 = findAndDeleteMin(nums2);
        int numMin2 = findAndDeleteMin(nums2);

        int numMax1 = findAndDeleteMax(nums);
        int numMax2 = findAndDeleteMax(nums);

        return numMax1*numMax2 - numMin1*numMin2;
    }

    public int findAndDeleteMax(int[] nums){

        int max = -1;
        int ind = -1;

        for(int i = 0; i < nums.length; i++){

            if( nums[i] > max ) {
                max = nums[i];
                ind = i;
            }
        }

        nums[ind] = -1;

        return max;
    }

    public int findAndDeleteMin(int[] nums){

        int min = Integer.MAX_VALUE;
        int ind = -1;

        for(int i = 0; i < nums.length; i++){

            if( nums[i] < min ) {
                min = nums[i];
                ind = i;
            }
        }

        nums[ind] = Integer.MAX_VALUE;

        return min;
    }


}
