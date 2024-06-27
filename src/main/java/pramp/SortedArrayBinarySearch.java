package pramp;

public class SortedArrayBinarySearch {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while( start <= end ){
            int mid = (start+end)/2;

            if( nums[mid] == target ) return mid;

            //left sorted portion
            if( nums[mid] >= nums[start] ){
                if( target > nums[mid] || target < nums[start] ) start = mid+1;
                else end = mid-1;
            }

            //right sorted portion
            else {
                if( target < nums[mid] || target > nums[end] ) end = mid-1;
                else start = mid+1;
            }
        }

        return -1;
    }


}
