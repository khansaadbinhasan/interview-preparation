package leetcode.medium;

//[9,12,5,10,14,3,10]
//10
//[-3,4,3,2]
//2
//[-3,4,3,2]
//3
//[9]
//9
//[1,2,3,4,4,5,6,1]
//1
public class L2161PartitionWithPivot {

    public int[] pivotArray(int[] nums, int pivot) {

        int[] pivotArr = new int[nums.length];
        int k = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] < pivot ){
                pivotArr[k] = nums[i];
                k++;
            }
        }

        int l = nums.length-1;

        for( int i = nums.length-1; i >= 0; i-- ){
            if( nums[i] > pivot ){
                pivotArr[l] = nums[i];
                l--;
            }
        }

        for( int i = k; i <= l; i++ ){
            pivotArr[i] = pivot;
        }

        return pivotArr;

    }


}
