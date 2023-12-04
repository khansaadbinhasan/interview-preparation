package leetcode.easy;

//[1,3,5,6]
//5
//[1,3,5,6]
//2
//[1,3,5,6]
//7
//[1,3,5,6]
//0
//[1]
//0
//[1]
//1
//[1,2,3]
//4
//[1,2,3,4,5,6,9]
//7
//[1,2,3]
//0
//[1,2]
//0
//[1]
//100
//[1]
//0
//[1,2,3,4,5,100]
//89
//[1,5,7]
//6

public class L35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        int mid = (start + end) / 2;

        boolean isEnd = false;

        while( start <= end ){

            mid = (start + end) / 2;

            if( nums[mid] == target ) return mid;

            if( nums[mid] > target ){
                isEnd = true;
                end = mid - 1;
            }
            else if( nums[mid] < target ){
                start = mid + 1;
                isEnd = false;
            }
        }

        return isEnd ? end + 1 : start;
    }
}
