package leetcode.easy;

//[-1,0,3,5,9,12]
//9
//[-1,0,3,5,9,12]
//2
//[1]
//1
//[1]
//2
//[1,2,3,4]
//4
//[1,2,3]
//3
public class L704BinarySearch {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while( start <= end ){

            int mid = (start + end) / 2;

            if( nums[mid] == target ) return mid;

            if( target > nums[mid]  ) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }


}
